package simulator;

import logging.FileLogging;
import tools.SimulatorFilesUtil;

import java.util.logging.Logger;

public class Simulator {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public void runFromFile(String file) {
        String simulationString = SimulatorFilesUtil.fileToString(file);
        run(simulationString);
        FileLogging.getInstance().closeFile();
    }

    public void runFromString(String simulationString) {
        run(simulationString);
    }

    private void run(String simulationString)
    {
        Simulation simulation = new Simulation(simulationString);
        WeatherTower weatherTower = new WeatherTower();
        for (Flyable flyable: simulation.getFlyableArrayList())
            flyable.registerTower(weatherTower);
        for (int i = 0; i < simulation.getNumberOfSimulations(); i++) {
            logger.info("Simulation Number : " + i);
            weatherTower.changeWeather();
        }
    }
}
