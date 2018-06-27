package Controller;

import org.junit.jupiter.api.Test;

class SimulatorTest {

    @Test
    public void simulateFromString()
    {
        Simulator simulator = new Simulator();
        simulator.runFromString("25\n" +
                "Baloon B1 2 3 20\n" +
                "Baloon B2 1 8 66\n" +
                "JetPlane J1 23 44 32\n" +
                "Helicopter H1 654 33 20\n" +
                "Helicopter H2 22 33 44\n" +
                "Helicopter H3 98 68 99\n" +
                "Baloon B3 102 22 34\n" +
                "JetPlane J2 11 99 768\n" +
                "Helicopter H4 223 23 54");

    }
}