package bank.service;

import bank.observer.AccountChangeObserver;

public class SmsSender implements AccountChangeObserver {

    private void sendSms(String msg){
        System.out.println("Sms sender: Sending sms with message "+msg);
    }
    @Override
    public void update(String msg) {
        sendSms(msg);

    }
}
