package bank.observer;

import java.util.ArrayList;
import java.util.Collection;

public class AccountChangeSub {
    private Collection<AccountChangeObserver> observers= new ArrayList<>();

    public void addObserver(AccountChangeObserver observer){
        observers.add(observer);
    }
    public void removeObserver(AccountChangeObserver observer){
        observers.add(observer);
    }
    public void accountChangeNotify(String msg){
        for(AccountChangeObserver observer: observers){
            observer.update(msg);
        }
    }
}
