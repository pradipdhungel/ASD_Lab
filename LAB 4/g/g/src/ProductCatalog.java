import java.util.ArrayList;
import java.util.List;

public class ProductCatalog extends Categories {

    List<Categories> categories = new ArrayList<>();

    public ProductCatalog(CategoryType categoryType) {
        super(categoryType);
    }

    @Override
    double calculatePrice() {
        return categories.stream()
                .mapToDouble(Categories::calculatePrice)
                .sum();
    }

    @Override
    void print() {
        categories.forEach(Categories::print);
    }

    public void addCategory(Categories category) {
        categories.add(category);
    }

    public void removeCategory(Categories category) {
        categories.remove(category);
    }
}
