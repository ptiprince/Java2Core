package Lesson7;

public class WeatherFiveDays {
    private String cityName;
    private String date;
    Integer temperatureMinimum;
    Integer temperatureMaximum;
    private String weatherTextDay;
    private String weatherTextNight;

    public WeatherFiveDays(String cityName, String date, Integer temperatureMinimum,
                           Integer temperatureMaximum, String weatherTextMinimum, String weatherTextMaximum) {
        this.cityName = cityName;
        this.date = date;
        this.temperatureMinimum = temperatureMinimum;
        this.temperatureMaximum = temperatureMaximum;
        this.weatherTextDay = weatherTextMinimum;
        this.weatherTextNight = weatherTextMaximum;
    }

    public String getCityName() { return cityName; }

    public void setCityName(String cityName) { this.cityName = cityName; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public Integer getTemperatureMinimum() { return temperatureMinimum; }

    public void setTemperatureMinimum(Integer temperatureMinimum) { this.temperatureMinimum = temperatureMinimum; }

    public Integer getTemperatureMaximum() { return temperatureMaximum; }

    public void setTemperatureMaximum(Integer temperatureMaximum) { this.temperatureMaximum = temperatureMaximum; }

    public String getWeatherTextDay() { return weatherTextDay; }

    public void setWeatherTextDay(String weatherTextDay) { this.weatherTextDay = weatherTextDay; }

    public String getWeatherTextNight() { return weatherTextNight; }

    public void setWeatherTextNight(String weatherTextNight) { this.weatherTextNight = weatherTextNight; }

    @Override
    public String toString() {
        return "The weather in " + cityName + " on date " + date + " is:\n" +
                "min temperature in Fahrenheit is " + temperatureMinimum  +
                ", max temperature in Fahrenheit is " + temperatureMaximum + ".\n" +
                "Weather conditions for daytime is: " + weatherTextDay +
                ". Weather conditions for night is: " + weatherTextNight + ".";
    }
}
