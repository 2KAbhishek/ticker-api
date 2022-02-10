package co.incubyte.posts;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.exceptions.HttpStatusException;

@Controller("tickers")
public class StockController {

  private final StockService stockService;

  public StockController(StockService stockService) {
    this.stockService = stockService;
  }

  @Get("/{ticker}")
  public HttpResponse<Stock> getStockByTicker(String ticker) {
    try {
      Stock stock = stockService.getStockByTicker(ticker);
      return HttpResponse.ok(stock);
    } catch (HttpStatusException e) {
      return HttpResponse.notFound();
    }
  }
}
