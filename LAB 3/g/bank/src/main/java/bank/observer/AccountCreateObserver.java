package bank.observer;

import bank.domain.Account;

public interface AccountCreateObserver {
    public void update(Account account);
}
