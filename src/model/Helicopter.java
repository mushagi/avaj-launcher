package model;

import java.util.logging.Logger;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower _weatherTower;
    Logger logger = Logger.getLogger(this.getClass().getName());

    public Helicopter(String _name, Coordinate _coordinate) {
        super(_name, _coordinate);
        super.set_type("Helicopter");
    }

    @Override
    public void updateConditions() {
        String weather = _weatherTower.getWeather(this.get_coordinate());
        String message;

        switch (weather)
        {
            case "SUN":
                get_coordinate().set_longitude(get_coordinate().get_longitude()+10);
                get_coordinate().set_height(get_coordinate().get_height()+2);
                break;
            case "RAIN" :
                get_coordinate().set_longitude(get_coordinate().get_longitude()+5);
                break;
            case "FOG" :
                get_coordinate().set_longitude(get_coordinate().get_longitude()+1);
                break;
            case "SNOW" :
                get_coordinate().set_height(get_coordinate().get_height()+12);
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
        _weatherTower.register(this);
    }
}
