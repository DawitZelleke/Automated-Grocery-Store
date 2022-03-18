package myStore;//Cory Helm 101171699
//Dawit  zelleke 101139907
import java.util.*;


public class Inventory implements ProductStockContainer {

    private HashMap<Product, Integer> inventory;

    public Inventory(int quantity) { this.inventory = new HashMap<Product, Integer>();}


    public HashMap<Product, Integer> getInventory() {
        return inventory;
    }

    /**
     * get the price of an item based of its id
     * @param id
     * @return the price
     */
    public double getPrice(String id){
        for (Product key : inventory.keySet()) {
            if (key.getId().equals(id)) {
                return key.getPrice();
            }
        }
        return -1;
    }

    /**
     * gets a certain product based of ID used in the GUI to add and remove items from cart and inventory making sure the right item is removed or added
     * @param id the id of an item
     * @return ether the Product that we are removing or null
     */
    public Product getAProduct(String id){
        for (Product keys : this.inventory.keySet()){
            if (keys.getId().equals(id)) {
                return keys;
            }
        }
        return null;
    }

    /**
     * add quantity of stock to a given product or adds the product to the inventory
     */
    @Override
    public void addProductQuantity(Product product, int added) {
        for (Product keys : this.inventory.keySet()){
            if (keys.getName().equals(product.getName()) && keys.getId().equals(product.getId()) && keys.getPrice() == product.getPrice()){
                this.inventory.replace(keys, this.inventory.get(keys), this.inventory.get(keys) + added);
                return;
            }
        }
        this.inventory.put(product, added);

    }
    /**
     * Removes a given amount of stock not allowing it to be under zero
     */
    @Override
    public void removeProductQuantity(Product product, int removed) {
        for (Product key : inventory.keySet()) {
            if (key.getId().equals(product.getId())) {
                if (removed <= inventory.get(key)) {
                    inventory.replace(key, inventory.get(key) - removed);
                }
                else {
                    return;
                }
            }
        }
    }

    /**
     * check the amount of stock in inventory based of id
     * @param product
     * @return
     */
    @Override
    public int getProductQuantity(Product product) {
        for (Product key: this.inventory.keySet()){
            if (key.getId().equals(product.getId())) {
                return this.inventory.get(key);
            }
        }
        return -1;
    }

    @Override
    public int getNumOfProducts(){
        return this.inventory.size();
    }

}
