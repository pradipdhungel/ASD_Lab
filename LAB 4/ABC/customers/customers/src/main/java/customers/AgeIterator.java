package customers;

import java.util.List;

public class AgeIterator implements Iterator<Customer> {
    private List<Customer> customers;
    private int position;

    public AgeIterator(List<Customer> customers) {
        this.customers = customers;
        customers.sort(new AgeComparator());
    }


    @Override
    public boolean hasNext() {
        return position<customers.size();
    }

    @Override
    public Customer getNext() {
        return customers.get(position++);
    }
}
