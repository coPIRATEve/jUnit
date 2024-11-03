package strategy;

import example.Product;

import java.util.List;
public class AveragePriceStrategy implements SalesOperationStrategy {
    public double execute(List<Product> products) {
        return products.stream().mapToDouble(Product::getPrice).average().orElse(0);
    }
}
