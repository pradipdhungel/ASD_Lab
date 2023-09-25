package bank.dao.proxy;

import org.springframework.util.StopWatch;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimingProxy implements InvocationHandler {
    private Object target;

    public TimingProxy(Object target){
        this.target=target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        StopWatch stopWatch= new StopWatch();
        stopWatch.start();

        Object returnValue=method.invoke(target,args);
        stopWatch.stop();

        System.out.println("The method"+method.getName()+" will take"+stopWatch.getTotalTimeMillis()+" ms");
        return returnValue;
    }
}
