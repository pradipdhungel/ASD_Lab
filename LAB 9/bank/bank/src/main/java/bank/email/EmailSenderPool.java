package bank.email;

public class EmailSenderPool {
    private static volatile  EmailSenderPool pool;


    private  EmailSender emailSender=new EmailSender();

    private EmailSenderPool(){
        if(pool!=null){
            throw new RuntimeException("to get the single instance of the class used getInstance() method");

        }
    }

    public static EmailSenderPool getPool(){
        if(pool==null){
            synchronized (EmailSenderPool.class){
                if (pool==null) pool=new EmailSenderPool();
            }
        }
        return pool;
    }


    public Object readResolve(){
        return  getPool();
    }

    public EmailSender getEmailSender(){
        return emailSender;
    }

}
