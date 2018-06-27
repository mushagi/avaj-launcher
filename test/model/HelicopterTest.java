package model;

import factory.AircraftFactory;
import org.junit.jupiter.api.Test;

import java.util.Objects;

class HelicopterTest {

    @Test
    void updateConditions() {

        AircraftFactory aircraftFactory = new AircraftFactory();
        Flyable flyable = null;
        try {
            flyable = AircraftFactory.newAirCraft("Helicopter","H1", 1, 3, 5);
        } catch (Exception invalidAirCraftType) {
            invalidAirCraftType.printStackTrace();
        }
        WeatherTower tower = new WeatherTower();
        Objects.requireNonNull(flyable).registerTower(tower);
        flyable.updateConditions();
    }

    @Test
    void updateConditionsMultipleAircraft() {

        AircraftFactory aircraftFactory = new AircraftFactory();

        Flyable flyable;
        try {
            flyable = AircraftFactory.newAirCraft("Helicopter","H1", 1, 3, 5);

        Flyable flyable1 = AircraftFactory.newAirCraft("Helicopter","H2", 1, 3, 5);
        Flyable flyable2 = AircraftFactory.newAirCraft("Helicopter","H3", 1, 3, 5);
        Flyable flyable3 = AircraftFactory.newAirCraft("Helicopter","H4", 1, 3, 5);
        WeatherTower tower = new WeatherTower();

        flyable.registerTower(tower);
        flyable1.registerTower(tower);
        flyable2.registerTower(tower);
        flyable3.registerTower(tower);


        flyable.updateConditions();
        } catch (Exception invalidAirCraftType) {
            invalidAirCraftType.printStackTrace();
        }
    }

}
