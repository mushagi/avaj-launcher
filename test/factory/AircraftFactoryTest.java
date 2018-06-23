package factory;

import model.Aircraft;
import model.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AircraftFactoryTest {

    @Test
    void createNewAirCraft() {
        Coordinate coordinate = new Coordinate(1, 1, 7);
        Aircraft aircraft = new Aircraft("Helicopter", coordinate);

        assertEquals(aircraft.get_coordinate(), coordinate);
        assertEquals(aircraft.get_name(), "Helicopter");
    }

    @Test
    void checkIfRandomIDIsBetween1and1000() {
        Coordinate coordinate = new Coordinate(1, 1, 7);
        Aircraft aircraft = new Aircraft("Helicopter", coordinate);
        assertTrue((aircraft.get_id() <= 1));
        assertTrue((aircraft.get_id() >= 1));
    }

    @Test
    void addObserver() {
        Coordinate coordinate = new Coordinate(1, 1, 7);

        Aircraft aircraft = new Aircraft("Helicopter", coordinate);

        assertTrue((aircraft.get_id() <= 1));
        assertTrue((aircraft.get_id() >= 1));
    }
}