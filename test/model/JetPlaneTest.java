package model;

import CustomException.InvalidAirCraftType;
import factory.AircraftFactory;
import org.junit.jupiter.api.Test;

class JetPlaneTest {
    @Test
    void updateConditions() {

        AircraftFactory aircraftFactory = new AircraftFactory();
        Flyable flyable = null;
        try {
            flyable = AircraftFactory.newAirCraft("JetPlane","J1", 1, 3, 5);
        } catch (Exception invalidAirCraftType) {
            invalidAirCraftType.printStackTrace();
        }
        WeatherTower tower = new WeatherTower();
        flyable.registerTower(tower);
        flyable.updateConditions();

    }

    @Test
    void registerTower() {

    }

}