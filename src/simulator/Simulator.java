package simulator;

import simulator.logging.SimulatorLogger;
import tools.SimulatorFilesUtil;


public class Simulator {


    public void runFromFile(String file) {
        String simulationString = SimulatorFilesUtil.fileToString(file);
        run(simulationString);
        SimulatorLogger.closeFile();
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
            SimulatorLogger.logToScreen("Simulation Number : " + i);
            weatherTower.changeWeather();
        }
    }
}