package customers.aspect;


import customers.EmailSender;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class LogAdvice {

    //Question a) Modify the application so that whenever the sendEmail method on the EmailSender is called, a
    //log message is created (using an after advice AOP annotation).
    @After("execution(* customers.IEmailSender.sendEmail(..))")
    public void questionA(){
        System.out.println("Question A: After Advice");
        System.out.println("Method=sentEmail");
        System.out.println();
    }

    //Question b) Now change the log advice in such a way that the email address and the message are
    //logged as well. You should be able to retrieve the email address and the message through
    //the arguments of the sendEmail() method.
    @After("execution(* customers.IEmailSender.sendEmail(..)) && args(email,message)")
    public void questionB(JoinPoint joinPoint,String email,String message){
        System.out.println("Question b: After advice"+"method=sendEmail,address="+email+",message"+message);
        System.out.println();
    }


    //Question c) Change the log advice again, this time so that the outgoing mail server is logged as well.
    //The outgoingMailServer is an attribute of the EmailSender object, which you can
    //retrieve through the joinpoint.getTarget() method.
    @After("execution(* customers.IEmailSender.sendEmail(..)) && args(email,message)")
    public void questionC(JoinPoint joinPoint,String email,String message){
        EmailSender emailSender=(EmailSender) joinPoint.getTarget();
        System.out.println("Question c: After advice"+"method=sendEmail,address="+email+",message"+message+" outgoing mail server="+emailSender.getOutgoingMailServer());
        System.out.println();
    }

    //Question d) Write a new advice that calculates the duration of the method calls to the DAO object and
    //outputs the result to the console.
    @Around("execution(* customers.ICustomerDAO.save(..))")
    public Object questionD(ProceedingJoinPoint call) throws Throwable{
        StopWatch stopWatch=new StopWatch();
        stopWatch.start(call.getSignature().getName());
        Object returnValue=call.proceed();
        stopWatch.stop();

        long totalTime=stopWatch.getTotalTimeMillis();
        System.out.println("Question D: Around advice"+"method="+call.getSignature().getName()+", execution time="+totalTime+"ms");
        System.out.println();
        return returnValue;
    }

}
