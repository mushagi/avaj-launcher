package simulator;

import simulator.exception.InvalidFormatInFlyable;

import java.util.ArrayList;

class Simulation {

    private final ArrayList<Flyable> flyableArrayList = new ArrayList<>();
    private int numberOfSimulations;

    int getNumberOfSimulations() {
        return numberOfSimulations;
    }

    Simulation(String simulationString) {

        int numberOfSimulationString = -1;
        int lineCount = 1;
        String[] simulatorStringArray = simulationString.split("\\n");
        try {
            AddNumberOfSimulations(simulatorStringArray[0]);
            for (String line : simulatorStringArray) {
                if (numberOfSimulationString == -1) {
                    numberOfSimulationString++;
                    continue;
                }
                lineCount++;
                addLine(line.trim());

            }
            if (flyableArrayList.isEmpty())
                throw new InvalidFormatInFlyable("There are no flyables", 0);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Could not convert number at line " + lineCount);
            System.out.println(e.getMessage());

            System.exit(1);
        }
        catch (Exception e) {
            System.out.println("Invalid simulation format at line " + lineCount);
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public ArrayList<Flyable> getFlyableArrayList() {
        return flyableArrayList;
    }

    private void AddFlyable(String[] flyableStringArray) throws Exception {
        String type = flyableStringArray[0];
        String name= flyableStringArray[1];

        int longitude= Integer.parseInt(flyableStringArray[2]);
        int latitude= Integer.parseInt(flyableStringArray[3]);
        int height= Integer.parseInt(flyableStringArray[4]);

        flyableArrayList.add(AircraftFactory.newAirCraft(type, name, longitude, latitude, height));
    }

    private void AddNumberOfSimulations(String numberOfSimulations) {
        this.numberOfSimulations = Integer.parseInt(numberOfSimulations);
    }

    private void addLine(String simulationString) throws Exception {
        if (simulationString.equals("")) return;
        String[] flyableStringArray = simulationString.split("\\s+");
        if (flyableStringArray.length != 5)
            throw new InvalidFormatInFlyable(simulationString, flyableStringArray.length );
        else
            AddFlyable(flyableStringArray);
    }
}
