package model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import tools.WeatherProvider;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Tower {

    ArrayList<Flyable> observers;
    Logger logger = Logger.getLogger(this.getClass().getName());

    public Tower() {
        this.observers = new ArrayList<>();
    }

    public void register(Flyable flyable) {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
            Aircraft aircraft = (Aircraft) flyable;
            logger.info("Tower says: " +aircraft.get_type()+"#"+aircraft.get_name()+"("+aircraft.get_id()+") registered to " + this.getClass().getSimpleName());
        }
    }

    public void unRegister(Flyable flyable) {
        if (observers.contains(flyable))
        {
            Aircraft aircraft = (Aircraft) flyable;
            logger.info("Tower says: " +aircraft.get_type()+"#"+aircraft.get_name()+"("+aircraft.get_id()+") unregistered from " + this.getClass().getSimpleName());
            observers.remove(flyable);
        }
    }

    public void conditionsChanged() {
        for (Flyable observer : observers)
            observer.updateConditions();
    }
}
