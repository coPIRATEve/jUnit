package example;

import observer.SalesPublisher;
import strategy.SalesOperationStrategy;

import java.util.List;
public class SalesAnalysis {
    private static SalesAnalysis instance;
    private List<Product> products;
    private SalesPublisher publisher;

    private SalesAnalysis(List<Product> products, SalesPublisher publisher) {
        this.products = products;
        this.publisher = publisher;
    }

    public static SalesAnalysis getInstance(List<Product> products, SalesPublisher publisher) {
        if (instance == null) {
            instance = new SalesAnalysis(products, publisher);
        }
        return instance;
    }

    public void performAnalysis(SalesOperationStrategy strategy) {
        double result = strategy.execute(products);
        //System.out.println("Result: " + result);
        publisher.notifyObservers(result); // Уведомляем всех наблюдателей
    }
}
