package co.incubyte.posts;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.exceptions.HttpStatusException;
import jakarta.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class StockService {

  private StockGateway stockGateway;

  public StockService(StockGateway stockGateway) {
    this.stockGateway = stockGateway;
  }

  public Stock getStockByTicker(String ticker) {
    List<Stock> allStocks = stockGateway.getAllStocks();
    Optional<Stock> stock =
        allStocks.stream().filter(argStock -> argStock.getTicker().equals(ticker)).findFirst();
    if (stock.isEmpty()) {
      throw new HttpStatusException(
          HttpStatus.NOT_FOUND, "Stock Not Found having ticker=" + ticker);
    }
    return stock.get();
  }
}
