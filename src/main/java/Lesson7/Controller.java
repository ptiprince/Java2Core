package Lesson7;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private WeatherModel weatherModel = new AccuweatherModel();
   private Map<Integer, Period> choiceForForecast  = new HashMap<>();

    public Controller() {
        choiceForForecast.put(1, Period.NOW);
        choiceForForecast.put(5, Period.FIVE_DAYS);
        choiceForForecast.put(2, Period.DB);
    }

    public  void getWeather(String commandInput, String selectedCity) throws IOException, SQLException {
        Integer integerCommand = Integer.parseInt(commandInput);

        if (!choiceForForecast.containsKey(integerCommand)){
            throw new IOException("There is no choice for key entered" + integerCommand);
        }
        switch (choiceForForecast.get(integerCommand)) {
            case NOW:
                weatherModel.getWeather(selectedCity, Period.NOW);
                break;
            case FIVE_DAYS:
                weatherModel.getWeather(selectedCity, Period.FIVE_DAYS);
                break;
            case DB:
                weatherModel.getSavedToDBWeather();
        }
    }
}
