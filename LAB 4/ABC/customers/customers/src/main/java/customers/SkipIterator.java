package customers;

import java.util.List;

public class SkipIterator implements Iterator<Customer> {
    private List<Customer> customers;
    private int position;

    public SkipIterator(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public boolean hasNext() {
        return position < customers.size();
    }

    @Override
    public Customer getNext() {
        Customer customer = customers.get(position);
        position = position + 2;
        return customer;
    }
}
