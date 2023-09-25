package customers;

import java.util.List;
import java.util.function.Predicate;

public class FilterIterator implements Iterator<Customer> {

    private List<Customer> customers;

    private int position = 0;
    private Predicate<Customer> predicate;

    public FilterIterator(List<Customer> customers, Predicate<Customer> predicate) {
        this.customers = customers;
        this.predicate = predicate;
    }


    @Override
    public boolean hasNext() {
        int tempPosition = position;
        while (tempPosition < customers.size()) {
            Customer nextElement = customers.get(tempPosition);
            if (predicate.test(nextElement)) {
                return true;
            }
            tempPosition++;
        }


        return false;
    }

    @Override
    public Customer getNext() {
        int tempPosition = position;
        while (tempPosition < customers.size()) {
            Customer nextElement = customers.get(tempPosition);
            if (predicate.test(nextElement)) {
                position = tempPosition + 1;
                return nextElement;
            }
            tempPosition++;
        }
        return null;
    }
}
