package example;

import observer.SalesPublisher;
import observer.SalesReport;
import strategy.AveragePriceStrategy;
import strategy.TotalSalesStrategy;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            ProductFactory factory = new ProductFactory();
            List<Product> products = factory.createProducts("src/test/sales.json");

            SalesPublisher publisher = new SalesPublisher();
            SalesReport report = new SalesReport();
            //SalesReport report1 = new SalesReport();
            publisher.addObserver(report);
            //publisher.addObserver(report1);

            SalesAnalysis analysis = SalesAnalysis.getInstance(products, publisher);
            analysis.performAnalysis(new TotalSalesStrategy()); // Подсчет общих продаж
            analysis.performAnalysis(new AveragePriceStrategy()); // Подсчет средней цены
            //analysis.performAnalysis(new AveragePriceStrategy());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}