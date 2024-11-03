package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import example.Product;
import example.SalesAnalysis;
import observer.SalesPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import strategy.SalesOperationStrategy;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.*;

class SalesAnalysisTest {

    private SalesPublisher mockPublisher;
    private SalesOperationStrategy mockStrategy;
    private List<Product> products;
    private SalesAnalysis salesAnalysis;

    @BeforeEach
    void setUp() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        products = mapper.readValue(new File("src/test/resources/sales.json"), new TypeReference<>() {});

        mockPublisher = Mockito.mock(SalesPublisher.class);
        mockStrategy = Mockito.mock(SalesOperationStrategy.class);

        salesAnalysis = SalesAnalysis.getInstance(products, mockPublisher);
    }

    @Test
    void testPerformAnalysis() {
        when(mockStrategy.execute(products)).thenReturn(10000.0);

        salesAnalysis.performAnalysis(mockStrategy);

        verify(mockPublisher, times(1)).notifyObservers(10000.0);
        verify(mockStrategy, times(1)).execute(products);
    }
}
