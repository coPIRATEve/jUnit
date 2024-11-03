package tests;

import observer.SalesPublisher;
import observer.Observer;
import observer.SalesReport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

class SalesPublisherTest {

    private SalesPublisher salesPublisher;
    private Observer observerMock1;
    private Observer observerMock2;

    @BeforeEach
    void setUp() {
        salesPublisher = new SalesPublisher();
        observerMock1 = Mockito.mock(SalesReport.class);
        observerMock2 = Mockito.mock(SalesReport.class);
    }

    @Test
    void testAddObserverAndNotifyObservers() {
        salesPublisher.addObserver(observerMock1);
        salesPublisher.addObserver(observerMock2);

        double salesResult = 5000.0;
        salesPublisher.notifyObservers(salesResult);

        verify(observerMock1, times(1)).update(salesResult);
        verify(observerMock2, times(1)).update(salesResult);
    }

    @Test
    void testRemoveObserver() {
        salesPublisher.addObserver(observerMock1);
        salesPublisher.addObserver(observerMock2);
        salesPublisher.removeObserver(observerMock1);

        double salesResult = 3000.0;
        salesPublisher.notifyObservers(salesResult);
        verify(observerMock1, times(0)).update(salesResult);
        verify(observerMock2, times(1)).update(salesResult);
    }
}
