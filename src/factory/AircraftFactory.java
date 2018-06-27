package factory;

import CustomException.CouldNotCreateAirCraftException;
import CustomException.InvalidAirCraftType;
import CustomException.InvalidRangeOfCoordinateHeight;
import com.sun.tools.corba.se.idl.InvalidArgument;
import model.*;

public class AircraftFactory{

    public static Flyable newAirCraft(String type, String name, int longitude ,int latitude, int height) throws Exception {

        Coordinate coordinate = new Coordinate(longitude,latitude ,height);
        switch (type)
        {
            case "Helicopter" : return new Helicopter(name, coordinate);
            case "Baloon" : return new Baloon(name, coordinate);
            case "JetPlane": return new JetPlane(name, coordinate);
            default: throw new InvalidAirCraftType();
        }
    }
}
