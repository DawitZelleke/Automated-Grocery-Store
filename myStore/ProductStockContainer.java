//Cory helm 101171699
// Dawit Zelleke 101139907
package myStore;

public interface ProductStockContainer {

    int getProductQuantity(Product product);

    void addProductQuantity(Product product, int amount);

    void removeProductQuantity(Product product, int amount);

    int getNumOfProducts();



}
