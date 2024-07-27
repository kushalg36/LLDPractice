package cart;

public abstract class Product {
    String name;
    double amount;
    ProductType productType;

    public Product(){}

    Product(String name, double price, ProductType productType) {
        this.name = name;
        this.amount = price;
        this.productType = productType;
    }

    public abstract double getPrice();

    public ProductType getProductType() {
        return productType;
    }
}
