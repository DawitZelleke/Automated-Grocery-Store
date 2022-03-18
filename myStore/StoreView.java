//Cory Helm 101171699
//Dawit  zelleke 101139907
package myStore;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StoreView {
    /**
     * attributes
     */
    private StoreManager sm;
    private int cartID;
    private JPanel mainPanel, infoPanel, picturePanel,buttonPanel, buttonPanel1, buttonPanel2, buttonPanel3;
    private JFrame frame;
    private JButton addItem1;
    private JButton removeItem1;
    private JButton addItem2;
    private JButton removeItem2;
    private JButton addItem3;
    private JButton removeItem3;
    private JButton checkout;
    private JButton Quit;
    private JLabel info;
    private JLabel item1Info;
    private JLabel item2Info;
    private JLabel item3Info;
    private JLabel[] imageLabels;


    /**
     * constructor for all our panels and labels and buttons along with the manager and cartid
     * @param manager
     * @param ID
     */
    public StoreView(StoreManager manager, int ID) {
        this.sm = manager;
        this.cartID = ID;
        this.mainPanel = new JPanel(new GridLayout());
        this.infoPanel = new JPanel(new BorderLayout());
        this.picturePanel = new JPanel(new BorderLayout());
        this.buttonPanel = new JPanel(new BorderLayout());
        this.buttonPanel1 = new JPanel(new BorderLayout());
        this.buttonPanel2 = new JPanel(new BorderLayout());
        this.buttonPanel3 = new JPanel(new BorderLayout());
        this.frame = new JFrame("");
        this.addItem1 = new JButton("+");
        this.addItem2 = new JButton("+");
        this.addItem3 = new JButton("+");
        this.removeItem1 = new JButton("-");
        this.removeItem2 = new JButton("-");
        this.removeItem3 = new JButton("-");
        this.checkout = new JButton("Checkout");
        this.Quit = new JButton("Quit");
        this.info = new JLabel();
        this.item1Info = new JLabel();
        this.item2Info = new JLabel();
        this.item3Info = new JLabel();
        this.imageLabels = new JLabel[3];
        Image apple = new ImageIcon(this.getClass().getResource("apple.png")).getImage();
        this.imageLabels[0] = new JLabel(new ImageIcon(apple));

        Image pear = new ImageIcon(this.getClass().getResource("pear.png")).getImage();
        this.imageLabels[1] = new JLabel(new ImageIcon(pear));

        Image phone = new ImageIcon(this.getClass().getResource("phone.png")).getImage();
        this.imageLabels[2] = new JLabel(new ImageIcon(phone));

    }

    public void displayGUI() {

        /**
         * setting the dimension for all our buttons and panels
         */
        imageLabels[0].setPreferredSize(new Dimension(166,153));
        imageLabels[1].setPreferredSize(new Dimension(166,153));
        imageLabels[2].setPreferredSize(new Dimension(166,153));
        addItem1.setPreferredSize(new Dimension(166, 51));
        addItem2.setPreferredSize(new Dimension(166, 51));
        addItem3.setPreferredSize(new Dimension(166, 51));
        removeItem1.setPreferredSize(new Dimension(166, 51));
        removeItem2.setPreferredSize(new Dimension(166, 51));
        removeItem3.setPreferredSize(new Dimension(166, 51));
        item1Info.setPreferredSize(new Dimension(166, 51));
        item2Info.setPreferredSize(new Dimension(166, 51));
        item3Info.setPreferredSize(new Dimension(166, 51));
        checkout.setPreferredSize(new Dimension(166, 51));
        Quit.setPreferredSize(new Dimension(166, 51));
        info.setPreferredSize(new Dimension(31, 357));
        buttonPanel.add(buttonPanel1, BorderLayout.PAGE_START);
        buttonPanel.add(buttonPanel2, BorderLayout.CENTER);
        buttonPanel.add(buttonPanel3, BorderLayout.PAGE_END);
        buttonPanel1.add(addItem1, BorderLayout.PAGE_START);
        buttonPanel2.add(addItem2, BorderLayout.PAGE_START);
        buttonPanel3.add(addItem3, BorderLayout.PAGE_START);
        buttonPanel1.add(removeItem1, BorderLayout.CENTER);
        buttonPanel2.add(removeItem2, BorderLayout.CENTER);
        buttonPanel3.add(removeItem3, BorderLayout.CENTER);
        infoPanel.add(info, BorderLayout.PAGE_START);
        infoPanel.add(checkout, BorderLayout.CENTER);
        infoPanel.add(Quit, BorderLayout.PAGE_END);
        buttonPanel1.add(item1Info, BorderLayout.PAGE_END);
        buttonPanel2.add(item2Info, BorderLayout.PAGE_END);
        buttonPanel3.add(item3Info, BorderLayout.PAGE_END);
        picturePanel.add(imageLabels[0], BorderLayout.PAGE_START);
        picturePanel.add(imageLabels[1], BorderLayout.CENTER);
        picturePanel.add(imageLabels[2], BorderLayout.PAGE_END);
        item1Info.setText("Stock of apple: " + (sm.checkStock(sm.getProduct("1"))));
        item2Info.setText("Stock of pear: " + (sm.checkStock(sm.getProduct("2"))));
        item3Info.setText("Stock of phone: " + (sm.checkStock(sm.getProduct("3"))));
        info.setText("Products in cart:");



        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?")
                        == JOptionPane.OK_OPTION) {
                    // close it down!
                    frame.setVisible(false);
                    frame.dispose();
                }
            }
        });
        /**
         * this method and action lister allows us to add item one to a person cart
         */
        addItem1.addActionListener(new ActionListener() {
            // this method will be called when we click the button
            @Override
            public void actionPerformed(ActionEvent ae) {
                Product p = sm.getProduct("1");
                sm.addItem(p, 1,cartID);
                sm.removeInventory(sm.getProduct("1"),1);
                if (sm.checkStock(sm.getProduct("1")) == 0){
                    addItem1.setEnabled(false);
                    item1Info.setText("Stock of apple: " + (sm.checkStock(sm.getProduct("1"))));
                }
                item1Info.setText("Stock of apple: " + (sm.checkStock(sm.getProduct("1"))));
                removeItem1.setEnabled(true);
                updateCart();

            }
        });

        addItem2.addActionListener(new ActionListener() {
            // this method will be called when we click the button
            @Override
            public void actionPerformed(ActionEvent ae) {
                Product p = sm.getProduct("2");
                sm.addItem(p, 1,cartID);
                sm.removeInventory(sm.getProduct("2"),1);
                if (sm.checkStock(sm.getProduct("2")) == 0){
                    addItem2.setEnabled(false);
                    item2Info.setText("Stock of pear: " + (sm.checkStock(sm.getProduct("2"))));
                }
                item2Info.setText("Stock of pear: " + (sm.checkStock(sm.getProduct("2"))));
                removeItem2.setEnabled(true);
                updateCart();
            }
        });
        addItem3.addActionListener(new ActionListener() {

            // this method will be called when we click the button
            @Override
            public void actionPerformed(ActionEvent ae) {
                Product p = sm.getProduct("3");
                sm.addItem(p, 1,cartID);
                sm.removeInventory(sm.getProduct("3"),1);
                if (sm.checkStock(sm.getProduct("3")) == 0){
                    addItem3.setEnabled(false);
                    item3Info.setText("Stock of phone: " + (sm.checkStock(sm.getProduct("3"))));
                }
                item3Info.setText("Stock of phone: " + (sm.checkStock(sm.getProduct("3"))));
                removeItem3.setEnabled(true);
                updateCart();
            }
        });

        /**
         * sets the removeitem buttons to false so that we cannot remove from an empty cart
         */
        removeItem1.setEnabled(false);
        removeItem2.setEnabled(false);
        removeItem3.setEnabled(false);
        /**
         * actions listener for removeitem to allows us to remove items from someones cart for items 1,2,3
         */
        removeItem1.addActionListener(new ActionListener() {
            // this method will be called when we click the button
            @Override
            public void actionPerformed(ActionEvent ae) {
                addItem1.setEnabled(true);
                Product p = sm.getProduct("1");
                sm.removeItem(p, 1,cartID);
                sm.addToInventory(1,p);
                if (sm.CheckStockForCart(sm.getProduct("1"), cartID) == -1){
                    removeItem1.setEnabled(false);
                    item1Info.setText("Stock of apple: " + (sm.checkStock(sm.getProduct("1"))));
                }
                item1Info.setText("Stock of apple: " + (sm.checkStock(sm.getProduct("1"))));
                updateCart();
            }
        });
        removeItem2.addActionListener(new ActionListener() {

            // this method will be called when we click the button
            @Override
            public void actionPerformed(ActionEvent ae) {
                addItem2.setEnabled(true);
                Product p = sm.getProduct("2");
                sm.removeItem(p, 1,cartID);
                sm.addToInventory(1,p);
                if (sm.CheckStockForCart(sm.getProduct("2"), cartID) == -1){
                    removeItem2.setEnabled(false);
                    item2Info.setText("Stock of pear: " + (sm.checkStock(sm.getProduct("2"))));
                }
                item2Info.setText("Stock of pear: " + (sm.checkStock(sm.getProduct("2"))));
                updateCart();
            }
        });
        removeItem3.addActionListener(new ActionListener() {

            // this method will be called when we click the button
            @Override
            public void actionPerformed(ActionEvent ae) {
                addItem3.setEnabled(true);
                Product p = sm.getProduct("3");
                sm.removeItem(p, 1,cartID);
                sm.addToInventory(1,p);
                if (sm.CheckStockForCart(sm.getProduct("3"), cartID) == -1){
                    removeItem3.setEnabled(false);
                    item3Info.setText("Stock of phone: " + (sm.checkStock(sm.getProduct("3"))));
                }
                item3Info.setText("Stock of phone: " + (sm.checkStock(sm.getProduct("3"))));
                updateCart();
            }
        });

        checkout.addActionListener(new ActionListener() {
            // this method will be called when we click the button
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (JOptionPane.showConfirmDialog(frame,checkout())
                        == JOptionPane.OK_OPTION) {
                    frame.setVisible(false);
                    frame.dispose();
                }
            }
        });

        /**
         * out quit action listern that will quit the program if pressed but ask if you want to first
         */
        Quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?")
                        == JOptionPane.OK_OPTION) {
                    // close it down!
                    frame.setVisible(false);
                    frame.dispose();
                }
            }
        });

        /**
         * lets the frame size and makes it not resizable
         */
        mainPanel.add(infoPanel);
        mainPanel.add(picturePanel);
        mainPanel.add(buttonPanel);
        frame.add(mainPanel);
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
     * will update what is in the cart for the person and allow us to print it on the left hand size in real time
     */
    public void updateCart(){
        StringBuilder s = new StringBuilder("<html>Products in cart <br/>");
        for (int i= 0; i < sm.getCartProducts(cartID).size(); i++){
            s.append(sm.getCartProducts(cartID).get(i).getName()).append(" ").append(sm.getCartStock(cartID).get(i)).append("<br/>");
        }
        s.append("</html>");
        info.setText(s.toString());
    }

    /**
     * checkout function that calculates the money cost and makes sure the person would like to checkout.
     * @return all the items in the cart and cost of items
     */
    public StringBuilder checkout(){
        StringBuilder s = new StringBuilder("Products checking out \n");
        for (int i= 0; i < sm.getCartProducts(cartID).size(); i++) {
            s.append(sm.getCartProducts(cartID).get(i).getName() + " " + sm.getCartStock(cartID).get(i) + "\n") ;

        }
        s.append("\n Your final price is: " + sm.transaction(cartID));
        return s;
    }

    /**
     * main that calls out displayGUI and creates a new storemanager.
     * @param args
     */
    public static void main(String[] args) {
        StoreManager sm = new StoreManager();
        StoreView st = new StoreView(sm, sm.assignNewCartID());
        st.displayGUI();
    }




}
