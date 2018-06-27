package tools;

import model.Coordinate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WeatherProvider {


    private static final WeatherProvider weatherProvider = new WeatherProvider();
    private static final Map<Coordinate,String> weatherCoordinates = new HashMap<Coordinate,String>();
    static String			weather[] = {"RAIN", "RAIN", "FOG", "SNOW"};

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    private WeatherProvider() {
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
        int random = rand.nextInt(4);
        return weather[random];
    }
}
