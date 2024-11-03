package observer;

public class SalesReport implements Observer {
    @Override
    public void update(double salesResult) {
        System.out.println("Sales report updated. New result: " + salesResult);
    }
}
