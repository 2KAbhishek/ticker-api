package co.incubyte.posts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StockServiceShould {

  private StockGateway stockGateway;
  private StockService stockService;

  @BeforeEach
  void init() {
    stockGateway = mock(StockGateway.class);
    stockService = new StockService(stockGateway);
    when(stockGateway.getAllStocks()).thenReturn(buildMockStockList());
  }

  private List<Stock> buildMockStockList() {
    Stock s1 = new Stock("TATAMOTORS", "TATA MOTORS Limited", 99);
    Stock s2 = new Stock("paytm", "PAYTM LIMITED", 123);
    return List.of(s1, s2);
  }

  @Test
  void invoke_stock_gateway_get_all_stocks() {
    stockService.getStockByTicker("TATAMOTORS");
    verify(stockGateway).getAllStocks();
  }

  @Test
  void return_stock_info_with_given_ticker() {
    StockService stockService = new StockService(stockGateway);
    Stock stock = stockService.getStockByTicker("TATAMOTORS");
    assertEquals("TATAMOTORS", stock.getTicker());
  }
}
