import cart.*;

public class Main {
    public static void main(String[] args) {
        Product item1 = new Item1("FAN", 1000, ProductType.ELECTRONICS);
        Product item2 = new Item2("MAGGI", 2000, ProductType.FOOD);

        ShoppingCart cart = new ShoppingCart();

        cart.addToCart(item1);
        cart.addToCart(item2);

        System.out.println("price: " + cart.totalPrice());
    }
}