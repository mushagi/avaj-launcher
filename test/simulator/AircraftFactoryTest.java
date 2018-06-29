package simulator;

import simulator.Aircraft;
import simulator.Coordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AircraftFactoryTest {

    @Test
    void createNewAirCraft() {
        Coordinates coordinates;
        coordinates = new Coordinates(1, 1, 7);
        Aircraft aircraft = new Aircraft("Helicopter", coordinates);

        assertEquals(aircraft.getCoordinates(), coordinates);
        assertEquals(aircraft.getName(), "Helicopter");
    }

    @Test
    void checkIfRandomID() {
        Coordinates coordinates;
        coordinates = new Coordinates(1, 1, 7);
        Aircraft aircraft1 = new Aircraft("Helicopter", coordinates);
        Aircraft aircraft2 = new Aircraft("Helicopter", coordinates);
        Aircraft aircraft3 = new Aircraft("Helicopter", coordinates);
        Aircraft aircraft4 = new Aircraft("Helicopter", coordinates);
        Aircraft aircraft5= new Aircraft("Helicopter", coordinates);
        Aircraft aircraft6 = new Aircraft("Helicopter", coordinates);
        Aircraft aircraft7 = new Aircraft("Helicopter", coordinates);
        Aircraft aircraft8 = new Aircraft("Helicopter", coordinates);

        assertEquals(aircraft1.getId(), 1);
        assertEquals(aircraft2.getId(), 2);
        assertEquals(aircraft3.getId(), 3);
        assertEquals(aircraft4.getId(), 4);
        assertEquals(aircraft5.getId(), 5);
        assertEquals(aircraft6.getId(), 6);
        assertEquals(aircraft7.getId(), 7);
        assertEquals(aircraft8.getId(), 8);
    }

    @Test
    void addObserver() {
        Coordinates coordinates;
        coordinates = new Coordinates(1, 1, 8);

        Aircraft aircraft = new Aircraft("Helicopter", coordinates);

        assertTrue((aircraft.getId() <= 1));
        assertTrue((aircraft.getId() >= 1));
    }

}