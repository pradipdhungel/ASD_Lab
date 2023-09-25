package bank.allcommands;

import bank.domain.Account;

public class DepositCommand implements Command{
     Account account;
     double amt;

    public DepositCommand(Account account, double amt) {
        this.account = account;
        this.amt = amt;
    }

    @Override
    public void execute() {
        account.deposit(amt);

    }

    @Override
    public void unExecute() {
        account.withdraw(amt);
    }
}
