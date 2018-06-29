package simulator;

import exception.InvaliFormatInFlyable;

import java.util.ArrayList;

class Simulation {

    private final ArrayList<Flyable> flyableArrayList = new ArrayList<>();
    private int numberOfSimulations;

    public int getNumberOfSimulations() {
        return numberOfSimulations;
    }

    Simulation(String simulationString) {

        int numberOfSimulationString = -1;
        String[] simulatorStringArray = simulationString.split("\n");
        try {
            AddNumberOfSimulations(simulatorStringArray[0]);
            for (String line : simulatorStringArray) {
                if (numberOfSimulationString == -1) {
                    numberOfSimulationString++;
                    continue;
                }
                addLine(line.trim());
            }
            if (flyableArrayList.isEmpty())
                throw new Exception("There must be at least one flyable");
        } catch (Exception e) {
            e.printStackTrace();
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
        String[] flyableStringArray = simulationString.split(" ");
        if (flyableStringArray.length != 5)
            throw new InvaliFormatInFlyable(simulationString);
        else
            AddFlyable(flyableStringArray);
    }
}
