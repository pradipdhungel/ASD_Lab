package with.templatemethod;

public class Paypal extends PaymentProcessor {

    private String address;

    public Paypal(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    @Override
    public boolean validate() {
        System.out.println("validate paypal address as "+getAddress());
        return true;
    }

    @Override
    public void payment(double amount, Customer customer) {
        if(validate()){
            //paypal payment logic
            System.out.println("Perform payment with the paypal address as " +getAddress()+" and with amount $"+amount);
            //notify customer logic
            System.out.println(customer.getName()+" Notify with email address"+customer.getEmail()+" with paypal address as "+getAddress());
        }

    }
}
