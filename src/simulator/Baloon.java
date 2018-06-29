package simulator;

import logging.FileLogging;

import java.util.logging.Logger;
class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    Baloon(String _name, Coordinates _coordinates) {
        super(_name, _coordinates);
        super.setType("baloon");
    }

    @Override
    public void updateConditions() {

        String weather = weatherTower.getWeather(this.getCoordinates());
        StringBuilder message = new StringBuilder(this.getType()+ "#"+this.getName()+"("+this.getId()+"): ");

        switch (weather)
        {
            case "SUN":
                getCoordinates().setLongitude(getCoordinates().getLongitude()+2);
                getCoordinates().setHeight(getCoordinates().getHeight()+4);
                break;
            case "RAIN" :
                getCoordinates().setHeight(getCoordinates().getHeight()-5);
                break;
            case "FOG" :
                getCoordinates().setHeight(getCoordinates().getHeight()-3);
                break;
            case "SNOW" :
                getCoordinates().setHeight(getCoordinates().getHeight()-15);
                break;
        }

        if (getCoordinates().getHeight() == 0) {
            super.hasLanded();
            message.append("landing");
        }
        logger.info(message.toString());
        FileLogging.getInstance().writeToFile(message.toString());
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}
