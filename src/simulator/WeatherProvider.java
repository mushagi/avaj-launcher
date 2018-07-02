package simulator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WeatherProvider {
    private static final WeatherProvider weatherProvider = new WeatherProvider();
    private static final Map<Coordinates, String> weatherCoordinates = new HashMap<>();
    private static final String[] weather = {"RAIN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinate) {
        for (Coordinates coordinates: weatherCoordinates.keySet()) {
            if (coordinate.getHeight() == coordinates.getHeight() &&
                    coordinate.getLatitude() == coordinates.getLatitude() &&
                    coordinates.getLongitude() == coordinates.getLongitude()) {
                int seed = coordinates.getHeight() * coordinates.getLongitude() * coordinates.getLatitude();
                return generateRandomWeather(seed);
            }
        }
        weatherCoordinates.put(coordinate, generateRandomWeather(0));
        return getCurrentWeather(coordinate);
    }

    private String generateRandomWeather(int seed) {
        Random rand = (seed == 0)? new Random() : new Random(seed);
        int random = rand.nextInt(4);
        return weather[random];
    }
}
