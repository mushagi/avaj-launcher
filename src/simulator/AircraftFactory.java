package simulator;

import simulator.exception.InvalidAirCraftType;

class AircraftFactory {
    public static Flyable newAirCraft(String type, String name, int longitude, int latitude, int height) throws Exception {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        switch (type) {
            case "Helicopter":
                return new Helicopter(name, coordinates);
            case "Baloon":
                return new Baloon(name, coordinates);
            case "JetPlane":
                return new JetPlane(name, coordinates);
            default:
                throw new InvalidAirCraftType();
        }
    }
}
