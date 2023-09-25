package product;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Logger implements ILogger{

    @Override
    public void log(String logstring) {
        System.out.println("Logging"+ LocalDateTime.now()+" "+logstring);
    }
}
