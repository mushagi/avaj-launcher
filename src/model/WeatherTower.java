package model;

import tools.WeatherProvider;

public class WeatherTower extends Tower {

    public String getWeather(Coordinate coordinate) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinate);
    }

    public void changeWeather() {
        WeatherProvider.getProvider().randomizeWeather();
        conditionsChanged();
    }
}
