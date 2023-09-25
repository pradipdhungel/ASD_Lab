package bank.decorator;

import bank.dao.IAccountDAO;

public abstract class AccountDAODecorator implements IAccountDAO {
    public IAccountDAO useComponent;
}
