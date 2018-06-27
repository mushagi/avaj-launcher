package Controller;

import model.Flyable;
import model.Simulation;
import model.WeatherTower;

public class Simulator {

    private void validateSimulation(Simulator simulation) {
    }

    public void runFromFile(String file) {

    }

    public void runFromString(String simulationString) {
        Simulation simulation = new Simulation(simulationString);
        run(simulation);
    }

    public void run(Simulation simulation)
    {
        WeatherTower weatherTower = new WeatherTower();
        for (Flyable flyable: simulation.getFlyables()) {
            flyable.registerTower(weatherTower);
        }
        for (int i = 0; i < simulation.get_numberOfSimulations(); i++) {
            System.out.println("Simulation Number : " + i+1);
            weatherTower.changeWeather();
        }
    }
}
