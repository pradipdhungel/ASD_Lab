package bank.email;

public class EmailSender implements IEmailSender {
    @Override
    public void sendEmail(String address, String msg) {
        System.out.println("EmailSender will sending email to "+address+",with following messafe ="+msg);
    }
}
