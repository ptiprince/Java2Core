package Lesson6;

import okhttp3.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WeatherRequestHomeWork6 {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient()
        .newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .build();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("/")
                .addQueryParameter("apikey", "P2fOkl6jGKwqQT2AqFpATAdfyTLb1YOU")
                .build();

        Request request = new Request.Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/349727?apikey=P2fOkl6jGKwqQT2AqFpATAdfyTLb1YOU")
                .get()
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        //Response body for the weather in NYC for next 5 days
        String responseBody = response.body().string();
        System.out.println(responseBody);
        System.out.println();
        System.out.println(response.code());
        System.out.println(response.headers());
        System.out.println(response.isRedirect());
        System.out.println(response.isSuccessful());
        System.out.println(response.protocol());
        System.out.println(response.receivedResponseAtMillis());

    }
}
