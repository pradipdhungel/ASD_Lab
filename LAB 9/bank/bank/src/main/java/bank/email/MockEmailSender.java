package bank.email;

public class MockEmailSender implements IEmailSender {
    @Override
    public void sendEmail(String address, String msg) {
        System.out.println("Using MockEmailSender this email is sending to "+",with the following message:"+msg);
    }
}
