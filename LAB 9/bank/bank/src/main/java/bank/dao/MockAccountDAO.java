package bank.dao;
//Write an abstract factory class with the following functionality:
//        1. Whenever the amount of an account changes, we send an email to the customer
//        (simulate with System.out.println()).
//        2. For testing, we want to use a MockAccountDAO and a MockEmailSender
//        3. For production we use the AccountDAO and en EmailSender class
//4. We specify the environment (production or test) in config.properties file.

import bank.domain.Account;

import java.util.ArrayList;
import java.util.Collection;

public class MockAccountDAO implements IAccountDAO{
     Collection<Account> accounts=new ArrayList<Account>();
    @Override
    public void saveAccount(Account account) {
        System.out.println("The Mocking Save account ");
        accounts.add(account);
    }

    @Override
    public void updateAccount(Account account) {
        System.out.println("The Mocking data update account");
        Account accountIsExist=loadAccount(account.getAccountnumber());
        if(accountIsExist!=null){
            accounts.remove(accountIsExist);
            accounts.add(account);
        }
    }

    @Override
    public Account loadAccount(long accountnumber) {
        System.out.println("The Mocking data load account");
        for(Account account:accounts){
            if(account.getAccountnumber()==accountnumber){
                return account;
            }
        }
        return null;
    }

    @Override
    public Collection<Account> getAccounts() {
        System.out.println("The Mocking get all accounts");
        return accounts;
    }
}
