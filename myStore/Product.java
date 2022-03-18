package myStore;

//Cory Helm 101171699
//Dawit  zelleke 101139907
public class Product {

    /**
     * attributes
     */
    private final String name;                        // name object
    private final String id;                // id
    private final double price;


    /**
     * constructs the store.Product
     * @param name of product
     * @param id products id
     * @param price how much it cost
     */
    public Product(String name, String id, double price) {this.name = name; this.id = id; this.price = price;}

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}


