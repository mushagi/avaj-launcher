package simulator;

import simulator.logging.SimulatorLogger;

import java.util.ArrayList;
import java.util.Iterator;

class Tower {
    private final ArrayList<Flyable> observers;

    Tower() {
        this.observers = new ArrayList<>();
    }

    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
            if (flyable instanceof Aircraft) {
                Aircraft aircraft = (Aircraft) flyable;
                SimulatorLogger.log("Tower says: " + aircraft.getType() + "#" + aircraft.getName() +
                        "(" + aircraft.getId() + ") registered to " + this.getClass().getSimpleName());
            }
        }
    }

    public void unRegister(Flyable flyable) {
        Aircraft aircraft = (Aircraft) flyable;
        SimulatorLogger.log("Tower says: " + aircraft.getType() + "#" + aircraft.getName() +
                "(" + aircraft.getId() + ") unregistered from " + this.getClass().getSimpleName());
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        for (Iterator<Flyable> iterator = observers.iterator(); iterator.hasNext(); ) {
            Flyable observer = iterator.next();
            if (observer instanceof Aircraft) {
                observer.updateConditions();
                Aircraft aircraft = (Aircraft) observer;
                SimulatorLogger.logToScreen(aircraft.getName() + " Height " + aircraft.getCoordinates().getHeight());
                if (aircraft.isLanded()) {
                    iterator.remove();
                    unRegister(observer);
                }
                if (observers.size() == 0){
                    SimulatorLogger.logToScreen("All aircrafts have landed.");
                    System.exit(0);
                }
            }
        }
    }
}