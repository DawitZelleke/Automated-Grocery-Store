//Cory Helm 101171699
//Dawit  zelleke 101139907
package myStore;
import java.util.*;
public class StoreManager {
    /**
     * attributes for inventory and cart
     */
    private Inventory inventory;
    private HashMap<Integer, ShoppingCart> personsCart;

    /**
     * initializes  the storeManager
     */
    public StoreManager() {

        this.inventory = new Inventory(0);
        this.personsCart = new HashMap<Integer, ShoppingCart>();
        addToInventory(20, new Product("apple", "1", 2.99));
        addToInventory(21, new Product("pear", "2", 5));
        addToInventory(23, new Product("phone", "3", 6));
        addToInventory(27, new Product("bear", "4", 10));

    }

    public void addToInventory(int added, Product product){
        this.inventory.addProductQuantity(product, added);
    }

    public int checkStock(Product product) {return this.inventory.getProductQuantity(product);
    }

    public Product getProduct(String id){
       return inventory.getAProduct(id);
    }

    /**
     * check the cart to see if it has anything in it
     * @param product id of the item
     * @param cartID id of the cart
     * @return returns -1 if nothing is in it or what stock is in it
     */
    public int CheckStockForCart(Product product, int cartID){
        for (int i =0; i< this.personsCart.size(); i++ ){
            if (i == cartID){
                return this.personsCart.get(i).getProductQuantity(product);
            }
        }
        return -1;
    }

    /**
     * gets the products that are in ones cart and where they are.
     * @param cartID
     * @return
     */
    public ArrayList<Product> getCartProducts(int cartID){
        for (int i =0; i< this.personsCart.size(); i++ ){
            if (i == cartID){
                return this.personsCart.get(i).keysOfHashmap();
            }
        }
        return null;

    }

    /**
     * how much stock is in ones cart based off an ID
     * @param cartID the id per cart
     * @return null or the value of a hashmap or the amount of an item
     */
    public ArrayList<Integer> getCartStock(int cartID){
        for (int i =0; i< this.personsCart.size(); i++ ){
            if (i == cartID){
                return this.personsCart.get(i).valueOfHashmap();
            }
        }
        return null;
    }


    /**
     * will take and cart and perform a transaction for every item
     * @param cartID what are is performing the transaction
     * @return total price of all objects
     */
    public double transaction(int cartID) {
        double totalPrice = 0;
        System.out.println("Items in the cart are");
        for (int i : this.personsCart.keySet()){
            if (i == cartID){
                for (int size = 0; size<this.getCartProducts(cartID).size(); size++){
                    System.out.println(this.getCartProducts(cartID).get(size).getName() + " with " + this.getCartStock(cartID).get(size) + " for $" + this.getCartProducts(cartID).get(size).getPrice());
                    totalPrice += this.getCartProducts(cartID).get(size).getPrice() * this.getCartStock(cartID).get(size);
                }
            }
        }
        return totalPrice;
    }

    public HashMap<Product, Integer> getInventory() {
        return this.inventory.getInventory();
    }

    /**
     * will add items to cart and remove it from inventory
     * @param product what product we are adding
     * @param amount how much we would like to add
     * @param cartID and what cart is it adding to
     */
    public void addItem(Product product, int amount, int cartID){
        if (this.personsCart.containsKey(cartID)){
            this.personsCart.get(cartID).addProductQuantity(product, amount);
        }



    }
    public void removeInventory(Product product, int amount){
        this.inventory.removeProductQuantity(product,amount);
    }

    /**
     * will remove items from cart and add them back to the inventory
     * @param product what product
     * @param amount how much is removed
     * @param cartID and what cart is it removed from
     */
    public void removeItem(Product product, int amount, int cartID){
        this.personsCart.get(cartID).removeProductQuantity(product, amount);
    }

    /**
     * will assign a cart id to track carts
     * @return cartID
     */
    public int assignNewCartID() {
        int cartID = this.personsCart.size();
        if(!this.personsCart.containsKey(cartID)) {
            this.personsCart.put(cartID, new ShoppingCart());
        }
        return cartID;
    }
}