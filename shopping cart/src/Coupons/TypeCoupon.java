package Coupons;

import cart.Product;
import cart.ProductType;

import java.util.ArrayList;
import java.util.List;

public class TypeCoupon extends Coupons{
    Product product;
    int discountPercentage;
    ProductType productType;
    static List<ProductType> eligibleProductType = new ArrayList<>();
    static {
        eligibleProductType.add(ProductType.FOOD);
    }

    public TypeCoupon(Product product, int discount, ProductType productType) {
        this.product = product;
        this.productType = productType;
        this.discountPercentage = discount;
    }

    @Override
    public double getPrice() {
        double price = product.getPrice();
        if(eligibleProductType.contains(productType)) {
            return price - (price * discountPercentage) / 100;
        }
        return price;
    }
}
