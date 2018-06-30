package simulator;

import logging.SimulatorLogger;

class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String _name, Coordinates _coordinates) {
        super(_name, _coordinates);
        super.setType("Helicopter");
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.getCoordinates());
        StringBuilder message = new StringBuilder(this.getType()+ "#"+this.getName()+"("+this.getId()+"): ");

        switch (weather)
        {
            case "SUN":
                getCoordinates().setLongitude(getCoordinates().getLongitude()+10);
                getCoordinates().setHeight(getCoordinates().getHeight()+2);
                break;
            case "RAIN" :
                getCoordinates().setLongitude(getCoordinates().getLongitude()+5);
                break;
            case "FOG"
                    :
                getCoordinates().setLongitude(getCoordinates().getLongitude()+1);
                break;
            case "SNOW" :
                getCoordinates().setHeight(getCoordinates().getHeight()+12);
                break;
        }
        if (getCoordinates().getHeight() == 0) {
            super.hasLanded();
            message.append("landing");
        }
        SimulatorLogger.log(message.toString());
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}
