package bank.service;

import java.util.Collection;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.observer.AccountChangeObserver;
import bank.observer.AccountChangeSub;
import bank.observer.AccountCreateObserver;
import bank.observer.AccountCreateSub;


public class AccountService extends AccountChangeSub implements IAccountService {
	private IAccountDAO accountDAO;

	private AccountCreateSub accountCreateSub;



	
	public AccountService(){
		accountDAO=new AccountDAO();
	}

	public AccountCreateSub getAccountCreateSub() {
		return accountCreateSub;
	}

	public void setAccountCreateSub(AccountCreateSub accountCreateSub) {
		this.accountCreateSub = accountCreateSub;
	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		accountCreateSub.accountCreateNotify(account);
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.deposit(amount);
		accountDAO.updateAccount(account);
		accountChangeNotify(amount+" amt is deposite  to"+accountNumber);

	}

	public Account getAccount(long accountNumber) {
		Account account = accountDAO.loadAccount(accountNumber);
		return account;
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
		accountChangeNotify(amount +" is withdraw from account number"+accountNumber);
	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
		accountChangeNotify(amount +" is transfer from account number"+fromAccountNumber
		+ "to ACCOUNT NUMBER:" +toAccountNumber);
	}
}
