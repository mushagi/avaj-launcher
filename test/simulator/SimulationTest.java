package simulator;

import org.junit.jupiter.api.Test;
import simulator.Simulation;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {
    @Test
    void get_numberOfSimulations() {
        Simulation simulation = new Simulation("12\n" + "                \n" + "\n");
        assertEquals(12, simulation.getNumberOfSimulations());
    }
}