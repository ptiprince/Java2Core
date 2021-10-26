package Lesson7.entity;

public class Weather {
    //cityName, weatherText, degrees
    private String cityName;
    private String localDate;
    private String weatherText;
    Double degrees;

    public Weather(String cityName, String localDate, String weatherText, Double degrees) {
        this.cityName = cityName;
        this.localDate = localDate;
        this.weatherText = weatherText;
        this.degrees = degrees;
    }

    public String getLocalDate() { return localDate; }

    public void setLocalDate(String localDate) { this.localDate = localDate; }

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

    public Double getDegrees() {
        return degrees;
    }

    public void setDegrees(Double degrees) {
        this.degrees = degrees;
    }

    @Override
    public String toString() {
        return "The weather for today in your city " + cityName  + " for the date " + localDate +
                " is: weather conditions: " + weatherText + "; temperature in Fahrenheit: " + degrees + ". ";
    }
}
