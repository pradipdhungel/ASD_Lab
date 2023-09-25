package bank.service;

import bank.domain.Account;
import bank.observer.AccountChangeObserver;
import bank.observer.AccountCreateObserver;

import java.util.Collection;

public class EmailSender implements AccountCreateObserver {
    public void sendEmail(Account account){
        System.out.println("Email sender is: Account create for "+account.getCustomer().getName()+"with following account number"+account.getAccountnumber());
    }
    @Override
    public void update(Account account) {
        sendEmail(account);
    }



}
