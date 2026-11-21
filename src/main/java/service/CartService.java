package service;
import java.util.ArrayList;
import model.CartItem;
import model.MenuItem;
import exceptions.InvalidQuantityException;
/* Handles adding, removing and updating cart items. */
public class CartService {
    private final ArrayList<CartItem> cart = new ArrayList<>();
    private CartItem findCartItemById(int id) {
    for (CartItem item : cart) {
        if (item.getItem().getId() == id) {
            return item;
        }
    }
    return null;
}
    public void addItem(MenuItem item, int quantity) throws InvalidQuantityException {
    if (quantity <= 0) {
        throw new InvalidQuantityException("Quantity must be greater than zero.");
    }

    CartItem existingItem = findCartItemById(item.getId());

    if (existingItem != null) {
        existingItem.setQuantity(existingItem.getQuantity() + quantity);
        System.out.println("Quantity updated in cart.");
        return;
    }

    cart.add(new CartItem(item, quantity));
    System.out.println("Item added to cart.");
}
    public void removeItem(int id) {
    CartItem item = findCartItemById(id);

    if (item != null) {
        cart.remove(item);
        System.out.println("Item removed.");
        return;
    }

    System.out.println("Item is not in the cart.");
}
    public void updateQuantity(int id, int quantity) throws InvalidQuantityException {
    if (quantity <= 0) {
        throw new InvalidQuantityException("Quantity must be greater than zero.");
    }

    CartItem item = findCartItemById(id);

    if (item != null) {
        item.setQuantity(quantity);
        System.out.println("Quantity updated.");
        return;
    }

    System.out.println("Item is not in the cart.");
}
    public void showCart() {
    if (cart.isEmpty()) {
        System.out.println("\n========== YOUR CART ==========");
        System.out.println("Your cart is empty.");
        System.out.println("===============================");
        return;
    }

    System.out.println("\n============== YOUR CART ==============");
    System.out.printf("%-20s %-10s %-12s%n", "Item", "Quantity", "Amount");
    System.out.println("---------------------------------------");

    for (CartItem item : cart) {
        System.out.printf("%-20s %-10d Rs. %-10.2f%n",
                item.getItem().getName(),
                item.getQuantity(),
                item.getAmount());
    }

    System.out.println("---------------------------------------");
    System.out.printf("Total Amount: Rs. %.2f%n", getTotal());
    System.out.println("=======================================");
}
    public double getTotal() {
        double total = 0;
        for (CartItem item : cart) total += item.getAmount();
        return total;
    }
    public ArrayList<CartItem> getCartCopy() {
        ArrayList<CartItem> copy = new ArrayList<>();
        for (CartItem item : cart) copy.add(new CartItem(item.getItem(), item.getQuantity()));
        return copy;
    }
    public void clearCart() { cart.clear(); }
    public boolean isEmpty() {
    return cart.isEmpty();
    }
    public int getItemCount() {
    return cart.size();
    }
    public int getTotalQuantity() {
    int count = 0;

    for (CartItem item : cart) {
        count += item.getQuantity();
    }

    return count;
}

}
