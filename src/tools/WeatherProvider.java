package tools;

import model.Coordinate;

import java.util.*;

public class WeatherProvider {


    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static Map<Coordinate,String> weatherCoordinates = new HashMap<Coordinate,String>();

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    private WeatherProvider() {
    }

    public static Collection<Coordinate> getWeatherCoordinates() {
        return weatherCoordinates.keySet();
    }

    public String getCurrentWeather(Coordinate coordinate)
    {
        for (Coordinate cordinate: weatherCoordinates.keySet()) {
            if (coordinate.get_height() == cordinate.get_height() &&
                    coordinate.get_latitude() == cordinate.get_latitude() &&
                    cordinate.get_longitude() == cordinate.get_longitude())
                return weatherCoordinates.get(cordinate);
        }
        weatherCoordinates.put(coordinate, generateRandomWeather());
        return getCurrentWeather(coordinate);
    }

    private String generateRandomWeather() {
        Random rand = new Random();
        int random = rand.nextInt(4) + 1;
        switch (random)
        {
            case 1 : return "RAIN";
            case 2 : return "SNOW";
            case 3 : return "SUN";
            case 4 : return "FOG";
        }
        return null;
    }

    public void randomizeWeather()
    {
        for (Coordinate cordinate: weatherCoordinates.keySet()) {
            weatherCoordinates.put(cordinate, generateRandomWeather());
        }
    }
}
