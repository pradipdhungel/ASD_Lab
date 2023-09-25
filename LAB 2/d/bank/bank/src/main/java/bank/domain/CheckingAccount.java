package bank.domain;

public class CheckingAccount implements InterestStrategy {

    @Override
    public double calculateInterest(double balance) {
        if(balance<1000){
            return (balance*1.5/100);
        }
        return (balance*2.5/100);
    }
}
