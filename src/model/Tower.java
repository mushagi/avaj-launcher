package model;

import tools.Global;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

class Tower {

    final ArrayList<Flyable> observers;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public Tower() {
        this.observers = new ArrayList<>();
    }

    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
            if (flyable instanceof Aircraft) {
                Aircraft aircraft = (Aircraft) flyable;
                logger.info("Tower says: " + aircraft.get_type() + "#" + aircraft.get_name() + "(" + aircraft.get_id() + ") registered to " + this.getClass().getSimpleName());
                Global.fileLogging.writeToFile("Tower says: " + aircraft.get_type() + "#" + aircraft.get_name() + "(" + aircraft.get_id() + ") registered to " + this.getClass().getSimpleName());

            }
        }
    }

    public void unRegister(Flyable flyable) {
        Aircraft aircraft = (Aircraft) flyable;
        logger.info("Tower says: " + aircraft.get_type() + "#" + aircraft.get_name() + "(" + aircraft.get_id() + ") unregistered from " + this.getClass().getSimpleName());
        Global.fileLogging.writeToFile("Tower says: " + aircraft.get_type() + "#" + aircraft.get_name() + "(" + aircraft.get_id() + ") unregistered from " + this.getClass().getSimpleName());
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
