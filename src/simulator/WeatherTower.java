package simulator;

class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinate) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinate);
    }

    void changeWeather() {
        conditionsChanged();
    }
}
