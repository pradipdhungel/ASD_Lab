public abstract class Categories {
    private CategoryType categoryType;

    public Categories(CategoryType categoryType){
        this.categoryType= categoryType;
    }
    abstract double calculatePrice();
    abstract void print();

}
