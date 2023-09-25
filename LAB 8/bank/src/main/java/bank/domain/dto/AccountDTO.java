package bank.domain.dto;

import bank.domain.AccountEntry;
import bank.domain.Customer;

import java.util.Collection;

public class AccountDTO {
    private long accountNumber;
    private Collection<AccountEntry> entries;
    private Customer customer;

    public AccountDTO(long accountNumber, Collection<AccountEntry> entries, Customer customer) {
        this.accountNumber = accountNumber;
        this.entries = entries;
        this.customer = customer;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Collection<AccountEntry> getEntries() {
        return entries;
    }

    public void setEntries(Collection<AccountEntry> entries) {
        this.entries = entries;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public double getBalance(){
        double balance=0;
        for (AccountEntry entry:entries){
            balance=entry.getAmount();
        }
        return balance;
    }
}

