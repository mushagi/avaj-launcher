package model;

import CustomException.InvalidNumberOfArgumentsInAFlyableString;
import factory.AircraftFactory;

import java.util.ArrayList;

public class Simulation {

    int _numberOfSimulations;
    ArrayList<Flyable> flyables = new ArrayList<>();
    private int _numberOfSimulationsCount;

    public int get_numberOfSimulations() {
        return _numberOfSimulations;
    }

    public Simulation(String simulationString) {

        String[] simulatorStringArray = simulationString.split("\n");
        _numberOfSimulationsCount = 0;
        try {
            for (String line : simulatorStringArray)
                addLine(line.trim());
            if (_numberOfSimulationsCount != 1)
                throw new InvalidNumberOfArgumentsInAFlyableString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Flyable> getFlyables() {
        return flyables;
    }

    public boolean AddFlyable(String[] flyableStringArray) throws Exception{

        String type = flyableStringArray[0];

        String name= flyableStringArray[1];

        int longitude= Integer.parseInt(flyableStringArray[2]);
        int latitude= Integer.parseInt(flyableStringArray[3]);
        int height= Integer.parseInt(flyableStringArray[4]);

        return flyables.add(AircraftFactory.newAirCraft(type, name, longitude, latitude, height));
    }

    public void AddNumberOfSimulations(String numberOfSimulations) {
        _numberOfSimulationsCount++;
        _numberOfSimulations = Integer.parseInt(numberOfSimulations);
    }


    public void addLine(String simulationString)  throws Exception{

        String[] flyableStringArray = simulationString.split(" ");
        if (simulationString.equals("")) return;
        else if (flyableStringArray.length == 1)
            AddNumberOfSimulations(simulationString);
        else if (flyableStringArray.length != 5)
            throw new InvalidNumberOfArgumentsInAFlyableString();
        else
            AddFlyable(flyableStringArray);
    }
}
