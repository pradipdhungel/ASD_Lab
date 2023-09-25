package bank.allcommands;

import bank.domain.Account;

public class TransferCommand implements Command{
    Account fromAccount;
    Account toAccount;
    double amt;
    String desc;

    public TransferCommand(Account fromAccount, Account toAccount, double amt, String desc) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amt = amt;
        this.desc = desc;
    }

    @Override
    public void execute() {
       fromAccount.transferFunds(toAccount,amt,desc);

    }

    @Override
    public void unExecute() {
      toAccount.transferFunds(fromAccount,amt,desc);
    }
}
