package customers.service;

import customers.event.NewCustomerEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementService {
    @EventListener
    public void eventListener(NewCustomerEvent event) {
        System.out.println("AdvertisementService: sending advertisement to " + event.getCustomer().getName());
    }
}
