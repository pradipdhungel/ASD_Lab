package counter.observer;

import java.util.ArrayList;
import java.util.Collection;
import counter.observer.Iobserver;
public class ObservableClass {
    private Collection<Iobserver> observers= new ArrayList<>();
    public void addObserver(Iobserver observer){
        observers.add(observer);
    }
    public void removeObserver(Iobserver observer){
        observers.remove(observer);
    }
    public void notify(int count){
        for (Iobserver observer: observers){
            observer.update(count);
        }
    }
}
