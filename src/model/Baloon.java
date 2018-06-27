package model;

import java.util.logging.Logger;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower _weatherTower;
    Logger logger = Logger.getLogger(this.getClass().getName());

    public Baloon(String _name, Coordinate _coordinate) {
        super(_name, _coordinate);
        super.set_type("baloon");
    }

    @Override
    public void updateConditions() {

        String weather = _weatherTower.getWeather(this.get_coordinate());
        String message;

        switch (weather)
        {
            case "SUN":
                get_coordinate().set_longitude(get_coordinate().get_longitude()+2);
                get_coordinate().set_height(get_coordinate().get_height()+4);
                break;
            case "RAIN" :
                get_coordinate().set_height(get_coordinate().get_height()-5);
                break;
            case "FOG" :
                get_coordinate().set_height(get_coordinate().get_height()-3);
                break;
            case "SNOW" :
                get_coordinate().set_height(get_coordinate().get_height()-15);
                break;
        }

        if (get_coordinate().get_height() == 0) message = "landing";
        else
            message =  "SPECIFIC_MESSAGE and " + weather;
        logger.info(this.get_type()+ "#"+this.get_name()+"("+this.get_id()+"):" + message);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this._weatherTower = weatherTower;
    }
}
