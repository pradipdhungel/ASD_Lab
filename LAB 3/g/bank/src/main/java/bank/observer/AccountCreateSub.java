package bank.observer;

import bank.domain.Account;

import java.util.ArrayList;
import java.util.Collection;

public class AccountCreateSub {
    private Collection<AccountCreateObserver> observers= new ArrayList<>();

    public void addObserver(AccountCreateObserver  observer){
        observers.add(observer);
    }
    public void removeObserver(AccountCreateObserver  observer){
        observers.add(observer);
    }

    public void accountCreateNotify(Account account){
        for (AccountCreateObserver observer:observers){
            observer.update(account);
        }
    }
}
