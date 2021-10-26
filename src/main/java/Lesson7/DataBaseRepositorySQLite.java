package Lesson7;

import Lesson7.entity.Weather;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRepositorySQLite implements DataBaseRepository {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    String filename = null;
    String createTableQuery = "CREATE TABLE IF NOT EXISTS weather (\n" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
            "cityName TEXT NOT NULL, \n" +
            "localDate TEXT NOT NULL, \n" +
            "weatherText TEXT NOT NULL, \n" +
            "degrees REAL NOT NULL, \n" +
            ");";

    private String insertWeather = "insert into weather (cityName, localDate, weatherText, degrees) values (?, ?, ?, ?)";
    private String getWeather = "select * from weather";
    private static final String DB_PATH = "jdbc:sqlite:geekbrains.db";

    @Override
    public boolean saveWeatherToDataBase(Weather weather) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getCityName());
            saveWeather.setString(2, weather.getLocalDate());
            saveWeather.setString(3, weather.getWeatherText());
            saveWeather.setDouble(4, weather.getDegrees());
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Сохранение погоды в базу данных не выполнено!");
    }

    public void saveWeatherToDataBase(List<Weather> weatherList) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            for (Weather weather : weatherList) {
                saveWeather.setString(1, weather.getCityName());
                saveWeather.setString(2, weather.getLocalDate());
                saveWeather.setString(3, weather.getWeatherText());
                saveWeather.setDouble(4, weather.getDegrees());
                saveWeather.addBatch();
            }
            saveWeather.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public List<Weather> getSavedToDBWeather() {
        List<Weather> weathers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getWeather);
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id"));
                System.out.println(" ");
                System.out.print(resultSet.getString("cityName"));
                System.out.println(" ");
                System.out.print(resultSet.getString("localDate"));
                System.out.println(" ");
                System.out.print(resultSet.getString("weatherText"));
                System.out.println(" ");
                System.out.print(resultSet.getDouble("degrees"));
                System.out.println(" ");
                weathers.add(new Weather(resultSet.getString("cityName"),
                        resultSet.getString("localDate"),
                        resultSet.getString("weatherText"),
                        resultSet.getDouble("degrees")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return weathers;
    }

    public static void main(String[] args) throws SQLException {
        DataBaseRepositorySQLite dataBaseRepository = new DataBaseRepositorySQLite();
        System.out.println(dataBaseRepository.getSavedToDBWeather());
    }
}
