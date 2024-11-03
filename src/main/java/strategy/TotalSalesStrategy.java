package strategy;

import example.Product;

import java.util.List;
public class TotalSalesStrategy implements SalesOperationStrategy {
    public double execute(List<Product> products) {
        return products.stream().mapToDouble(p -> p.getPrice() * p.getQuantitySold()).sum();
    }
}