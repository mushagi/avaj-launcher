package controller;

import model.Flyable;
import model.Simulation;
import model.WeatherTower;
import tools.Global;

import java.util.logging.Logger;

class Simulator {

    private final Logger logger = Logger.getLogger(this.getClass().getName());


    public void runFromFile(String file) {
        run(file);
        Global.fileLogging.closeFile();
    }

    public void runFromString(String simulationString) {
        run(simulationString);
    }

    private void run(String simulationString)
    {
        Simulation simulation = new Simulation(simulationString);
        WeatherTower weatherTower = new WeatherTower();
        for (Flyable flyable: simulation.getFlyables()) {
            flyable.registerTower(weatherTower);
        }
        for (int i = 0; i < simulation.get_numberOfSimulations(); i++) {
            logger.info("Simulation Number : " + i);
            weatherTower.changeWeather();
        }
    }
}
