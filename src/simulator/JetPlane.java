package simulator;

import logging.FileLogging;

import java.util.logging.Logger;

class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        super.setType("JetPlane");
    }

    @Override
    public void updateConditions() {
        Logger logger = Logger.getLogger(this.getClass().getName());
        String weather = weatherTower.getWeather(this.getCoordinates());
        StringBuilder message = new StringBuilder(this.getType()+ "#"+this.getName()+"("+this.getId()+"): ");
        switch (weather)
        {
            case "SUN":
                getCoordinates().setLatitude(getCoordinates().getLatitude()+10);
                getCoordinates().setHeight(getCoordinates().getHeight()+2);
                break;
            case "RAIN" :
                getCoordinates().setLatitude(getCoordinates().getLatitude()+5);
                break;
            case "FOG" :
                getCoordinates().setLatitude(getCoordinates().getLatitude()+1);
                break;
            case "SNOW" :
                getCoordinates().setHeight(getCoordinates().getHeight()-12);
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