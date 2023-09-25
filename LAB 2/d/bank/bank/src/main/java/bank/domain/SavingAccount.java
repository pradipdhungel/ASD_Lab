package bank.domain;

public class SavingAccount implements  InterestStrategy{
    @Override
    public double calculateInterest(double balance) {
        if (balance<1000){
            return (balance*1.5/100);
        }
        if (balance<5000){
            return (balance*2/100);
        }
        return (balance*4/100);
    }
}
