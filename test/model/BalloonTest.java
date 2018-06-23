package model;

import factory.AircraftFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalloonTest {


    @Test
    void updateConditions() {
        AircraftFactory aircraftFactory = new AircraftFactory();
        Flyable flyable = aircraftFactory.newAirCraft("Balloon","H1", 1, 3, 5);
        WeatherTower tower = new WeatherTower();
        flyable.registerTower(tower);
        flyable.updateConditions();
    }

    @Test
    void registerTower() {
    }

}