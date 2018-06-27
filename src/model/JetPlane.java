package model;

import java.util.logging.Logger;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower _weatherTower;

    public JetPlane(String name, Coordinate coordinate) {
        super(name, coordinate);
        super.set_type("JetPlane");
    }

    @Override
    public void updateConditions() {
        Logger logger = Logger.getLogger(this.getClass().getName());
        String weather = _weatherTower.getWeather(this.get_coordinate());
        String message;

        switch (weather)
        {
            case "SUN":
                get_coordinate().set_latitude(get_coordinate().get_latitude()+10);
                get_coordinate().set_height(get_coordinate().get_height()+2);
                break;
            case "RAIN" :
                get_coordinate().set_latitude(get_coordinate().get_latitude()+5);
                break;
            case "FOG" :
                get_coordinate().set_latitude(get_coordinate().get_latitude()+1);
                break;
            case "SNOW" :
                get_coordinate().set_height(get_coordinate().get_height()-12);
                break;
        }

        if (get_coordinate().get_height() == 0) message = "landing";
        else message =  "SPECIFIC_MESSAGE and " + weather;
        logger.info(this.get_type()+ "#"+this.get_name()+"("+this.get_id()+"):" + message);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this._weatherTower = weatherTower;
    }
}
