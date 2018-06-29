package simulator;

import simulator.Coordinates;
import org.junit.jupiter.api.Test;
import simulator.WeatherProvider;

class WeatherProviderTest {

    @Test
    void getCurrentWeather() {
        Coordinates c1;
        try {
            c1 = new Coordinates(7, 4, 5);
        Coordinates c2 = new Coordinates(7, 1, 5);
        Coordinates c3 = new Coordinates(3, 4, 5);
        Coordinates c4 = new Coordinates(7, 5, 5);
        Coordinates c5 = new Coordinates(7, 4, 5);
        Coordinates c6 = new Coordinates(7, 4, 5);
        WeatherProvider.getProvider().getCurrentWeather(c1);
        WeatherProvider.getProvider().getCurrentWeather(c2);
        WeatherProvider.getProvider().getCurrentWeather(c3);
        WeatherProvider.getProvider().getCurrentWeather(c4);
        WeatherProvider.getProvider().getCurrentWeather(c5);
        WeatherProvider.getProvider().getCurrentWeather(c6);

        } catch (Exception invalidRangeOfCoordinateHeight) {
            invalidRangeOfCoordinateHeight.printStackTrace();
        }
    }

}