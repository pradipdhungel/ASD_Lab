package customers.service;

import customers.event.NewCustomerEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class CustomerRatingService {
    @EventListener
    public void eventListener(NewCustomerEvent event) {
        System.out.println("CustomerRatingService: Rating service to " + event.getCustomer().getName());
    }
}
