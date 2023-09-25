package bank.allcommands;

import bank.domain.Account;

public class WithdrawCommand implements Command{
    Account account;
    double amt;

    public WithdrawCommand(Account account, double amt) {
        this.account = account;
        this.amt = amt;
    }

    @Override
    public void execute() {
       account.withdraw(amt);
    }

    @Override
    public void unExecute() {
    account.deposit(amt);
    }
}
