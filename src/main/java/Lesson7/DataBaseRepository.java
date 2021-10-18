package Lesson7;

import Lesson7.entity.Weather;

import javax.imageio.IIOException;
import java.sql.SQLException;
import java.util.List;

public interface DataBaseRepository {
    boolean saveWeatherToDataBase (Weather weather) throws SQLException;
    List<Weather> getSavedToDBWeather() throws IIOException;
}
