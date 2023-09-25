package bank.factory;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.decorator.AccountDAOLogger;
import bank.email.EmailSenderPool;
import bank.email.IEmailSender;

public class ProductionFactory implements MyFactory{

    @Override
    public IAccountDAO getAccountDAO() {
        return new AccountDAOLogger(new AccountDAO());
    }

    @Override
    public IEmailSender getEmailSender() {
        return EmailSenderPool.getPool().getEmailSender();
    }
}
