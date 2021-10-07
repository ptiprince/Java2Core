package Lesson6;

import okhttp3.*;

import java.io.IOException;

public class OkhttpBookingRequest {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        String requestBody = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                " }";

        MediaType JSON = MediaType.parse("JSON");
        RequestBody requestBodyBooker = RequestBody.create(requestBody, JSON);

        Request request = new Request.Builder()
                .url("https://restful-booker.herokuapp.com/auth")
                .post(requestBodyBooker)
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseBody = response.body().string();
        System.out.println(responseBody);

        String token = responseBody.split(":")[1];
        System.out.println(token);
       String resultToken = token.replaceAll("[\"}]", "");
        System.out.println(resultToken);

        //Creating Post request "new booking" from https://restful-booker.herokuapp.com
        String requestBookingBody = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        RequestBody requestBodyBooking = RequestBody.create(requestBookingBody, JSON);
        Request requestBooking = new Request.Builder()
                .url("https://restful-booker.herokuapp.com/booking")
                .post(requestBodyBooking)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("Cookie", String.format("token=%s", resultToken))
                .build();

        Response responseBookingCreation = okHttpClient.newCall(requestBooking).execute();
        System.out.println(responseBookingCreation.body().string());

    }
}
