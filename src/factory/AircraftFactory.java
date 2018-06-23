package factory;

import model.*;

public class AircraftFactory{

    public Flyable newAirCraft(String type, String name, int height, int latitude, int longitude) {

        Coordinate coordinate = new Coordinate(height, latitude, longitude);

        switch (type)
        {
            case "Helicopter" : return new Helicopter(name, coordinate);
            case "Balloon" : return new Balloon(name, coordinate);
            case "JetPlane": return new JetPlane(name, coordinate);
            default: break;
        }
        return null;
    }
}
