package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("dev")
public class CustomerDAO implements ICustomerDAO {
    @Autowired
    private ILogger logger;

    public CustomerDAO(ILogger logger) {
        this.logger = logger;
    }

    @Override
    public void save(Customer customer) {
        try {
            Thread.sleep(350);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CustomerDAO: saving customer "+customer.getName());
        logger.log("Customer is saved in the DB:"+customer.getName());
    }

}
