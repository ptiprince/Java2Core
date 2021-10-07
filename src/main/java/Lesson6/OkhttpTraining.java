package Lesson6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static java.nio.file.attribute.AclEntry.newBuilder;

public class OkhttpTraining {
    public static void main(String[] args) throws IOException {
        //Class instance OkHttpClient is created through Builder and fulfill all the work to create and send request
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
                .host("geekbrains.ru")
                .addPathSegment("/")
                .addQueryParameter("apikey", "P2fOkl6jGKwqQT2AqFpATAdfyTLb1YOU")
                .build();
       //Class instance Request is created through pattern Builder
        //Web pages for patterns: https://refactoring.guru/ru/design-patterns
        Request request = new Request.Builder()
                .url("https://geekbrains.ru")
                .get()
                .build();

        Response response = okHttpClient.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.headers());
        System.out.println(response.isRedirect());
        System.out.println(response.isSuccessful());
        System.out.println(response.protocol());
        System.out.println(response.receivedResponseAtMillis());
        //Request body from the server
        String body = response.body().string();
        //System.out.println(response.body().string()); - can be used just once as .string is a stream so if
        // it was read once it is not kept after reading. So we save into String body to use further.
        System.out.println(body);
    }
}
