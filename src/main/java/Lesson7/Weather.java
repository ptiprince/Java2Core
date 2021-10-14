package Lesson7;

public class Weather {
    //cityName, weatherText, degrees
    private String cityName;
    private String weatherText;
    Integer degrees;

    public Weather(String cityName, String weatherText, Integer degrees) {
        this.cityName = cityName;
        this.weatherText = weatherText;
        this.degrees = degrees;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public Integer getDegrees() {
        return degrees;
    }

    public void setDegrees(Integer degrees) {
        this.degrees = degrees;
    }

    @Override
    public String toString() {
        return "The weather for today in your city " + cityName  +
                " is: weather conditions: " + weatherText +
                "; temperature in Fahrenheit: " + degrees + ". ";
    }
}
