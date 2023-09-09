package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    private int getState(int st) {
        return state;
    }

    private void setState(int st) {
        state = st;
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update();
        }
    }

}
