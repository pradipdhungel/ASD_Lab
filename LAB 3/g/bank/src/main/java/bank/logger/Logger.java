package bank.logger;


import bank.observer.AccountChangeObserver;

public class Logger implements AccountChangeObserver {
    private void log(String msg){
        System.out.println("Logger: Account change with:"+msg);
    }
    @Override
    public void update(String msg){
        log(msg);
    }
}
