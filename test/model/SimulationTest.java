package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {
    @Test
    void get_numberOfSimulations() {
        Simulation simulation = new Simulation("12\n" +  "Baloon H1 6 6 5" + "\n");
        assertEquals(12, simulation.get_numberOfSimulations());
    }
}