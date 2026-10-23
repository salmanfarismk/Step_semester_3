package encapsulation.assigment_problems;

/**
 * Problem 5: The Shopping Cart
 * Scenario: E-Commerce Secure Shopping Cart
 * 
 * Demonstrates encapsulation of internal collections and dynamic on-request computation.
 * Stores item prices privately, never exposing the raw pricing array, and provides
 * computed total and item count queries on demand.
 * 
 * Concepts: Collection encapsulation, on-demand computed properties, immutable IDs.
 */
public class Cart {

    private final String cartId;
    private final double[] prices;
    private int itemCount;

    /**
     * Initializes the shopping cart with a permanent ID and maximum item capacity.
     *
     * @param cartId   Permanent cart identifier
     * @param capacity Maximum number of items the cart can store
     */
    public Cart(String cartId, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Cart capacity must be positive.");
        }
        this.cartId = cartId;
        this.prices = new double[capacity];
        this.itemCount = 0;
    }

    /**
     * Adds an item price to the cart if capacity permits.
     *
     * @param price Price of the item to add
     */
    public void addItem(double price) {
        if (price < 0) {
            System.out.println("Invalid price. Cannot add negative price to cart.");
            return;
        }

        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        } else {
            System.out.println("Cart is full. Cannot add item with price: " + price);
        }
    }

    /**
     * Overloaded convenience method for adding integer prices.
     *
     * @param price Integer price of the item
     */
    public void addItem(int price) {
        addItem((double) price);
    }

    /**
     * Computes and returns the total sum of all item prices on request.
     * Calculated on the fly without exposing the underlying price array.
     *
     * @return Total sum of prices in the cart
     */
    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    /**
     * Returns the count of items added so far.
     *
     * @return Number of items in the cart
     */
    public int getItemCount() {
        return itemCount;
    }

    /**
     * Read-only getter for the cart ID.
     *
     * @return Permanent cart ID
     */
    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: The Shopping Cart ===");

        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("cart.getCartId() -> " + cart.getCartId());
        System.out.println("cart.getTotal() -> " + (int) cart.getTotal());
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());
    }
}
