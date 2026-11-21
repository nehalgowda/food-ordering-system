
package model;

/**
 * Represents one item selected by the customer.
 * Stores the menu item and the selected quantity.
 */
public class CartItem {

    private MenuItem item;
    private int quantity;

    /**
     * Creates a cart item with the given menu item and quantity.
     */
    public CartItem(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    // Returns the selected menu item.
    public MenuItem getItem() {
        return item;
    }

    // Returns the selected quantity.
    public int getQuantity() {
        return quantity;
    }

    // Updates the selected quantity.
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Calculates the total amount for this cart item.
    public double getAmount() {
        return item.getPrice() * quantity;
    }
}
