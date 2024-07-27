package cart;

import Coupons.PercentageCoupon;
import Coupons.TypeCoupon;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public void addToCart(Product product) {
        Product productWithEligibleDiscount =
            new TypeCoupon(new PercentageCoupon(product, 10), 3,  product.getProductType());

        products.add(productWithEligibleDiscount);
    }

    public int totalPrice() {
        int price = 0;
        for(Product product : products) {
            price += product.getPrice();
        }
        return price;
    }
}
