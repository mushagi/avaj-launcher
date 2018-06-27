package model;

import factory.AircraftFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TowerTest {
    @Test
    void whenAFlyableIsRegisteredItShouldBeAddedToTheObserversInATower() {

        AircraftFactory aircraftFactory = new AircraftFactory();
        Flyable flyable = null;
        try {
            flyable = AircraftFactory.newAirCraft("Helicopter", "H1", 1, 3, 5);
        } catch (Exception invalidAirCraftType) {
            invalidAirCraftType.printStackTrace();
        }

        Tower tower = new Tower();
        tower.register(flyable);
        assertEquals(tower.observers.get(0), flyable);
    }

    @Test
    void unRegisterANonExistingFlyable() {

        AircraftFactory aircraftFactory = new AircraftFactory();
        Flyable flyable;
        try {
            flyable = AircraftFactory.newAirCraft("Helicopter", "H2", 1, 3, 5);

        Flyable flyableTwo = AircraftFactory.newAirCraft("JetPlane","H3" ,1, 3, 5);

        Tower tower = new Tower();
        tower.register(flyable);
        tower.unRegister(flyableTwo);
        assertEquals(tower.observers.size(), 1);
        } catch (Exception invalidAirCraftType) {
            invalidAirCraftType.printStackTrace();
        }
    }
    @Test
    void unRegister() {

        AircraftFactory aircraftFactory = new AircraftFactory();
        Flyable flyable;
        try {
            flyable = AircraftFactory.newAirCraft("Helicopter", "h5",1, 3, 5);


        Tower tower = new Tower();
        tower.register(flyable);
        assertEquals(tower.observers.get(0), flyable);

        tower.unRegister(flyable);
        assertTrue(tower.observers.size() == 0);
        } catch (Exception invalidAirCraftType) {
            invalidAirCraftType.printStackTrace();
        }
    }

}