package Coupons;

import cart.Product;

public class PercentageCoupon extends Coupons{
    Product product;
    int discountPercentage;

    public PercentageCoupon(Product product, int percentage) {
        this.product = product;
        this.discountPercentage = percentage;
    }
    @Override
    public double getPrice() {
        return product.getPrice() - (product.getPrice() * discountPercentage)/100;
    }
}
