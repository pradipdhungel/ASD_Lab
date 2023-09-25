public class Product extends Categories {
    private String name;
    private CategoryType categoryType;
    private double price;

    public Product(String name, CategoryType categoryType, double price) {
        super(categoryType);
        this.name = name;
        this.categoryType = categoryType;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    double calculatePrice() {
        return getPrice();
    }

    @Override
    void print() {
        System.out.println("product{" + "name=" + name + ", categoryName=" + categoryType + ",price=" + price);
    }

}
