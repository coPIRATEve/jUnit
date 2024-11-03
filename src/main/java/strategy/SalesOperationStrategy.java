package strategy;

import example.Product;

import java.util.List;
public interface SalesOperationStrategy {
    double execute(List<Product> products);
}
