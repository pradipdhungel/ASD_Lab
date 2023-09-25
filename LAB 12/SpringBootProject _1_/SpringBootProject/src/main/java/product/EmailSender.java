package product;

import org.springframework.stereotype.Service;

@Service
public class EmailSender implements IEmailSender {
    String outgoingMailServer="smtp.acme.com";
    private ILogger logger;
    public EmailSender(ILogger logger){
        this.logger=logger;
    }
    @Override
    public void sendEmail(String email, String message) {
        System.out.println("EmailSender: sending"+message+"to"+email);
        logger.log("EmailSender: sending"+message+"to"+email);
    }

    @Override
    public String getOutgoingMailServer() {
        return outgoingMailServer;
    }
}
