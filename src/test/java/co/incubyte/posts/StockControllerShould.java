package co.incubyte.posts;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StockControllerShould {

  private StockService stockService;
  private StockController stockController;

  @BeforeEach
  void init() {
    stockService = mock(StockService.class);
    stockController = new StockController(stockService);
  }

  @Test
  void invoke_stock_service_get_stock_by_ticker() {
    stockController.getStockByTicker("TATAMOTORS");
    verify(stockService).getStockByTicker("TATAMOTORS");
  }
}
