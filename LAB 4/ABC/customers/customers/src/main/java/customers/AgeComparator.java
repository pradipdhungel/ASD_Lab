package customers;

import java.util.Comparator;

public class AgeComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer obj1,Customer obj2){
        return Integer.compare(obj1.getAge(),obj2.getAge());
    }

}
