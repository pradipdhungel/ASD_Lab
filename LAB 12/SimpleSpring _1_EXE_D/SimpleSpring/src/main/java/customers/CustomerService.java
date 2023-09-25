package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    //    ICustomerDAO customerDAO = new CustomerDAO();
//    IEmailSender emailSender = new EmailSender();
    ICustomerDAO customerDAO;
    IEmailSender emailSender;

    @Autowired
    public void setEmailSender(String emailSender) {
        this.customerDAO = customerDAO;
    }

    @Autowired
    public void setCustomerDAO(String customerDAO) {
        this.emailSender = emailSender;
    }

    public void addCustomer(String name, String email, String street,
                            String city, String zip) {
        Customer customer = new Customer(name, email);
        Address address = new Address(street, city, zip);
        customer.setAddress(address);
        customerDAO.save(customer);
        emailSender.sendEmail(email, "Welcome " + name + " as a new customer");
    }


}
