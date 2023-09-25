package bank.factory;

import java.io.InputStream;
import java.util.Properties;

public class DAOFactory {
    public MyFactory factory;

    public DAOFactory(){
        try{
            InputStream inputStream=getClass().getClassLoader().getResourceAsStream("config.properties");
            Properties props=new Properties();
            props.load(inputStream);
            String environment= props.getProperty("environment");

            if(environment.equals("production")){
                factory=new ProductionFactory();

            }else if(environment.equals("test")){
                factory=new MockFactory();
            }else {
                System.out.println("environment property not set correctly");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public MyFactory getFactoryInstance(){
        return factory;
    }
}
