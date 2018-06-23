package model;

import factory.AircraftFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TowerTest {
    @Test
    void whenAFlyableIsRegisteredItShouldBeAddedToTheObserversInATower() {
        AircraftFactory aircraftFactory = new AircraftFactory();
        Flyable flyable = aircraftFactory.newAirCraft("Helicopter", "H1", 1, 3, 5);

        Tower tower = new Tower();
        tower.register(flyable);
        assertEquals(tower.observers.get(0), flyable);
    }

    @Test
    void unRegisterANonExistingFlyable() {

        AircraftFactory aircraftFactory = new AircraftFactory();
        Flyable flyable = aircraftFactory.newAirCraft("Helicopter", "H2", 1, 3, 5);
        Flyable flyableTwo = aircraftFactory.newAirCraft("JetPlane","H3" ,1, 3, 5);

        Tower tower = new Tower();
        tower.register(flyable);
        tower.unRegister(flyableTwo);
        assertEquals(tower.observers.size(), 1);
    }
    @Test
    void unRegister() {

        AircraftFactory aircraftFactory = new AircraftFactory();
        Flyable flyable = aircraftFactory.newAirCraft("Helicopter", "h5",1, 3, 5);

        Tower tower = new Tower();
        tower.register(flyable);
        assertEquals(tower.observers.get(0), flyable);

        tower.unRegister(flyable);
        assertEquals(tower.observers.get(0), flyable);
    }

    @Test
    void conditionsChanged() {
    }

}