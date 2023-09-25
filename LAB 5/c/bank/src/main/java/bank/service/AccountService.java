package bank.service;

import java.util.Collection;

import bank.allcommands.DepositCommand;
import bank.allcommands.HistoryList;
import bank.allcommands.TransferCommand;
import bank.allcommands.WithdrawCommand;
import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;


public class AccountService implements IAccountService {
	private IAccountDAO accountDAO;
	private HistoryList historyList=new HistoryList();

	public void undo(){
		historyList.undo();
	}
	public void redo(){
		historyList.redo();
	}
	public AccountService(){
		accountDAO=new AccountDAO();
	}

	public Account createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountDAO.saveAccount(account);
		return account;
	}

	public void deposit(long accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);
		DepositCommand depositCommand=new DepositCommand(account,amount);
		depositCommand.execute();
		historyList.addCommand(depositCommand);
		accountDAO.updateAccount(account);
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
		WithdrawCommand withdrawCommand=new WithdrawCommand(account,amount);
		withdrawCommand.execute();
		historyList.addCommand(withdrawCommand);
		accountDAO.updateAccount(account);
	}



	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);
		TransferCommand transferCommand=new TransferCommand(fromAccount,toAccount,amount,description);
		transferCommand.execute();
		historyList.addCommand(transferCommand);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
	}
}
