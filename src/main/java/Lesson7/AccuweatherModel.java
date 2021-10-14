package Lesson7;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.Objects;

public class AccuweatherModel implements WeatherModel{
    //http://dataservice.accuweather.com/currentconditions/v1 - link for CURRENT forecast
    //http://dataservice.accuweather.com/forecasts/v1/daily/5day/349727 - link FOR 5 DAYS
    //http://dataservice.accuweather.com/locations/v1/cities/autocomplete - link for CITY KEY
    private static final String PROTOCOL = "http";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String CURRENT_CONDITIONS = "currentconditions";
    private static final String FORECASTS = "forecasts";
    private static final String DAILY = "daily";
    private static final String FIVE_DAYS = "5day";
    private static final String LOCATIONS = "locations";
    private static final String VERSION = "v1";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static ObjectMapper objectMapper = new ObjectMapper();
    //static ObjectMapper objectMapper2 = new ObjectMapper();

   public void getWeather(String selectedCity, Period period) throws IOException {
        if (period == Period.NOW) {
          HttpUrl httpUrl = new HttpUrl.Builder()
                  .scheme(PROTOCOL)
                   .host(BASE_HOST)
                .addPathSegment(CURRENT_CONDITIONS)
                  .addPathSegment(VERSION)
                   .addPathSegment(getCityKey(selectedCity))
                  .addQueryParameter("apikey", API_KEY)
                  .build();
             Request request = new Request.Builder()
                    .url(httpUrl)
                   .build();
            Response response = okHttpClient.newCall(request).execute();
            String responseString = response.body().string();
            String weatherText = objectMapper.readTree(responseString).get(0).at("/WeatherText").asText();
            Integer degrees = objectMapper.readTree(responseString).get(0).at("/Temperature/Metric/Value").asInt();
            Weather weather = new Weather(selectedCity, weatherText, degrees);
            System.out.println(weather);

            //System.out.println(response.body().string());
            //TODO Organize input in readable form
       }
       if (period == Period.FIVE_DAYS) {
            HttpUrl httpUrl = new HttpUrl.Builder()
                    .scheme(PROTOCOL)
                    .host(BASE_HOST)
                  .addPathSegment(FORECASTS)
                   .addPathSegment(VERSION)
                    .addPathSegment(DAILY)
                   .addPathSegment(FIVE_DAYS)
                  .addPathSegment(getCityKey(selectedCity))
                    .addQueryParameter("apikey", API_KEY)
                   .build();
           Request request = new Request.Builder()
                   .url(httpUrl)
                    .build();
            Response response = okHttpClient.newCall(request).execute();
            String responseFive = response.body().string();
            //String forecastFive = objectMapper.readTree(responseFive).get(1).at("/Date").asText();
          //System.out.println(forecastFive);
           System.out.println(responseFive);
          // System.out.println(response.body().string());
       }
    }

    public static String getCityKey(String city) throws IOException {
        HttpUrl httpUrl1 = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter("apikey", API_KEY)
                //required parameter cty is sent to the method too (String city)
                .addQueryParameter("q", city)
                .build();
        Request request = new Request.Builder()
                .url(httpUrl1)
                .build();
        Response response = okHttpClient.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("There was impossible to find chosen city info. " + "Server answer code = " +
                    "Response: " + response.body().string());
        }
            String responseBody = response.body().string();
         if (objectMapper.readTree(responseBody).size() > 0) {
             String cityName = objectMapper.readTree(responseBody).get(0).at("/LocalizedName").asText();
             String countryName = objectMapper.readTree(responseBody).get(0).at("/Country/LocalizedName").asText();
             System.out.println("Your city " + cityName + ", your country " + countryName);
         } else throw new IOException("Your city was not found");
        String cityKey = objectMapper.readTree(responseBody).get(0).at("/Key").asText();
        return cityKey;
    }

}
