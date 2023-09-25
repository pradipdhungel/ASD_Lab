package bank.decorator;

import bank.dao.IAccountDAO;
import bank.domain.Account;

import java.util.Collection;

public class AccountDAOLogger extends AccountDAODecorator {

    public AccountDAOLogger(IAccountDAO iAccountDAO){
        this.useComponent=iAccountDAO;
    }
    @Override
    public void saveAccount(Account account) {
        System.out.println("Data is save in Logger");
        useComponent.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        System.out.println("Data is update in Logger");
        useComponent.updateAccount(account);
    }

    @Override
    public Account loadAccount(long accountnumber) {
        return useComponent.loadAccount(accountnumber);
    }

    @Override
    public Collection<Account> getAccounts() {
        return useComponent.getAccounts();
    }
}
