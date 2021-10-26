package Lesson6;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class UrlTrainingPostRequest {
    public static void main(String[] args) throws MalformedURLException, IOException {
        //URL has different consrtructors. I used:
        // Login:password used to bypass authorization process + host + pass to resource + parameters (+ anchor if necessary)
        URL url = new URL("http://ptiprince:password@geekbrains.ru:80/courses?type=qa&level=suuper");
        //Can be used another constructor
        URL url1 = new URL("https", "geekbrains.ru", 443,"/");
       // System.out.println("Host: " + url.getHost());// can use .getProtocol();
       // System.out.println("File: " + url.getFile());
       // InputStream inputStream = url1.openStream();
       // new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
       // .lines() // method to read line by line and return stream
        //        .forEach(System.out::println);
        //.forEach(line -> System.out.println(line)) - == the line above

        //Different way to do the same task is below
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        //PrintWriter writer = new PrintWriter("geek.html"); - we will save geek.html
        //String line;
        //while ((line = bufferedReader.readLine()) != null) {
         //    System.out.println(line);
        //}
        //writer.close();
        //bufferedReader.close();

        //The task - to receive details of the response
        HttpURLConnection httpURLConnection1 = (HttpURLConnection) url.openConnection();
        httpURLConnection1.connect();
        System.out.println(httpURLConnection1.getResponseCode());
        System.out.println(httpURLConnection1.getResponseMessage());
        System.out.println(httpURLConnection1.getRequestMethod());
        System.out.println(httpURLConnection1.getConnectTimeout());
        System.out.println();
        //How to receive headers
        Map<String, List<String>> headers = httpURLConnection1.getHeaderFields();
        for (String k: headers.keySet()) {
            System.out.printf("Key: %s, value: %s \n", k, headers.get(k));
        }
        System.out.println();

        //POST request with http from https://restful-booker.herokuapp.com/
        URL urlBooker = new URL("https://restful-booker.herokuapp.com/auth");
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlBooker.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setDoOutput(true);
        String bookingPostJson = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                " }";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream()))) {
            bufferedWriter.write(bookingPostJson);
        }
        try (BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
            String line1 = "";
            while ((line1 = bufferedReader1.readLine()) != null) {
                System.out.println(line1);
            }
        }
    }
}

