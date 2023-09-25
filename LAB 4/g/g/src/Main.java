public class Main {
    public static void main(String[] args) {
        ProductCatalog appliance=new ProductCatalog(CategoryType.APPLIANCE);
        Product prod1=new Product("Freeze",CategoryType.APPLIANCE,2000);
        Product prod2=new Product("Vaccum",CategoryType.APPLIANCE,100);
        appliance.addCategory(prod1);
        appliance.addCategory(prod2);
        System.out.println("\n -----------------------------------Products in Appliances----------");
        appliance.print();
        System.out.println("Appliance total price"+appliance.calculatePrice());

        ProductCatalog homeDecor= new ProductCatalog(CategoryType.HOME_DECOR);
        Product prod3=new Product("Painting",CategoryType.APPLIANCE,2000);
        Product prod4=new Product("Carpet",CategoryType.APPLIANCE,1000);
        homeDecor.addCategory(prod3);
        homeDecor.addCategory(prod4);
        System.out.println("/n ------------Products for Home Decoration-----");
        homeDecor.print();
        System.out.println("Home decoration total price:"+homeDecor.calculatePrice());

        ProductCatalog allCatalogs=new ProductCatalog(CategoryType.ALL);
        allCatalogs.addCategory(appliance);
        allCatalogs.addCategory(homeDecor);

        System.out.println("\n ------------------------------------All Products-------------");
        allCatalogs.print();
        System.out.println("All Products total price"+allCatalogs.calculatePrice());

    }
}