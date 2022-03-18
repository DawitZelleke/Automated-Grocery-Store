package myStore;//Cory Helm 101171699
//Dawit  zelleke 101139907
import java.util.HashMap;
import java.util.*;
public class ShoppingCart implements ProductStockContainer{
    private HashMap<Product, Integer> Products;

    public ShoppingCart() {
        this.Products = new HashMap<Product, Integer>();
    }


    public ArrayList<Product> keysOfHashmap() {
        return new ArrayList<Product>(this.Products.keySet());
    }

    public ArrayList<Integer> valueOfHashmap() {
        return new ArrayList<Integer>(this.Products.values());
    }

    /**
     * get the amount of stock in inventory for a certain product id
     * @param product gets the id for product
     * @return
     */
    @Override
    public int getProductQuantity(Product product) {
        for (Product key: Products.keySet()){
            if (key.getId().equals(product.getId())) {
                return Products.get(key);
            }
        }
        return -1;
    }


    /**
     * adds items to the cart
     * @param product Product, the product in the hashmap
     * @param stock Integer, amount of stock
     */
    @Override
    public void addProductQuantity(Product product, int stock){
        if (this.Products.containsKey(product)){
            for (Product i: this.Products.keySet()){
                if (product.getId().equals(i.getId())){
                    this.Products.replace(product, this.Products.get(product), this.Products.get(product) + stock);
                }
            }
        }
        else {
            this.Products.put(product, stock);
        }
    }




    /**
     * will remove items from the cart
     * @param product the amo
     * @param stock
     */
    @Override
    public void removeProductQuantity(Product product, int stock){
        if (this.Products.containsKey(product)){
            for (Product i: this.Products.keySet()){
                if (product.getId().equals(i.getId())){
                    if (Products.get(i) - stock > 0){
                        this.Products.replace(product, this.Products.get(product), this.Products.get(product) - stock);
                        return;
                    }
                }
            }
        }
        else {
            return;
        }
        this.Products.remove(product);

    }

    @Override
    public int getNumOfProducts(){

        return Products.size();
    }


}
