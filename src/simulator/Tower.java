package simulator;

import logging.FileLogging;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

class Tower {

    private final ArrayList<Flyable> observers;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public Tower() {
        this.observers = new ArrayList<>();
    }

    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
            if (flyable instanceof Aircraft) {
                Aircraft aircraft = (Aircraft) flyable;
                logger.info("Tower says: " + aircraft.getType() + "#" + aircraft.getName() + "(" + aircraft.getId() + ") registered to " + this.getClass().getSimpleName());
                FileLogging.getInstance().writeToFile("Tower says: " + aircraft.getType() + "#" + aircraft.getName() + "(" + aircraft.getId() + ") registered to " + this.getClass().getSimpleName());

            }
        }
    }

    public void unRegister(Flyable flyable) {
        Aircraft aircraft = (Aircraft) flyable;
        logger.info("Tower says: " + aircraft.getType() + "#" + aircraft.getName() + "(" + aircraft.getId() + ") unregistered from " + this.getClass().getSimpleName());
        FileLogging.getInstance().writeToFile("Tower says: " + aircraft.getType() + "#" + aircraft.getName() + "(" + aircraft.getId() + ") unregistered from " + this.getClass().getSimpleName());
        observers.remove(flyable);
    }
    protected void conditionsChanged() {

        for (Iterator<Flyable> iterator = observers.iterator(); iterator.hasNext(); ) {
            Flyable observer = iterator.next();
            observer.updateConditions();
            if (observer instanceof Aircraft) {
                Aircraft aircraft = (Aircraft) observer;
                if (aircraft.isLanded()) {
                    iterator.remove();
                    unRegister(observer);
                }
            }
        }
    }
}
