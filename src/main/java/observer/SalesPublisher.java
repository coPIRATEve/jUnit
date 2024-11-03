package observer;

import java.util.List;
import java.util.ArrayList;
public class SalesPublisher {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(double salesResult) {
        for (Observer observer : observers) {
            observer.update(salesResult);
        }
    }
}
