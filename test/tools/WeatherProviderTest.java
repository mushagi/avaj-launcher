package tools;

import model.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherProviderTest {
    @Test
    void getProvider() {
    }

    @Test
    void getCurrentWeather() {
        Coordinate c1 = new Coordinate(7, 4, 5);
        Coordinate c2 = new Coordinate(7, 1, 5);
        Coordinate c3 = new Coordinate(3, 4, 5);
        Coordinate c4 = new Coordinate(7, 5, 5);
        Coordinate c5 = new Coordinate(7, 4, 5);
        Coordinate c6 = new Coordinate(7, 4, 5);
        WeatherProvider.getProvider().getCurrentWeather(c1);
        WeatherProvider.getProvider().getCurrentWeather(c2);
        WeatherProvider.getProvider().getCurrentWeather(c3);
        WeatherProvider.getProvider().getCurrentWeather(c4);
        WeatherProvider.getProvider().getCurrentWeather(c5);
        WeatherProvider.getProvider().getCurrentWeather(c6);

        assertEquals(WeatherProvider.getWeatherCoordinates().size(), 4);
    }

    @Test
    void randomizeWeather() {
    }

}