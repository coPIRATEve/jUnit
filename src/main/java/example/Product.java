package example;

public class Product {
    private int productId;
    private String productName;
    private double price;
    private int quantitySold;

    public Product(int productId, String productName, double price, int quantitySold) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantitySold = quantitySold;
    }
    public Product(){};
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantitySold() {
        return quantitySold;
    }
}
