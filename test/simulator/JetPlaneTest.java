package simulator;

import org.junit.jupiter.api.Test;

import java.util.Objects;

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
        Objects.requireNonNull(flyable).registerTower(tower);
        flyable.updateConditions();

    }

}