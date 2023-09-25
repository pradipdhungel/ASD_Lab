package with.templatemethod;

public class VisaCard extends PaymentProcessor {

    private String creditCardNumber;
    private String customerName;
    private String validDate;
    private int securityCode;


    public VisaCard(String creditCardNumber, String customerName, String validDate, int securityCode) {
        super();
        this.creditCardNumber = creditCardNumber;
        this.customerName = customerName;
        this.validDate = validDate;
        this.securityCode = securityCode;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }


    @Override
    public boolean validate() {
        System.out.println("validate the visa card with :" + getCreditCardNumber() + " card number");
        return true;
    }

    @Override
    public void payment(double amount, Customer customer) {
        if (validate()) {
            // visa card payment logic
            System.out.println("perform payment with visa card with"+getCreditCardNumber()+ " card number and amount $"+amount);
            // notify the customer
            System.out.println(customer.getName() +"is notify with the email"+customer.getEmail()+"about visa credit card payment with"+getCreditCardNumber()+" card number.");
        }
    }
}