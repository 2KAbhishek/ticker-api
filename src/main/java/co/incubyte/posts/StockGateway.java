package co.incubyte.posts;

import static io.micronaut.http.HttpRequest.GET;

import io.micronaut.core.type.Argument;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.util.List;

@Singleton
public class StockGateway {

  @Inject
  @Client("https://61deab5cfb8dae0017c2e196.mockapi.io/api/v1/")
  private HttpClient httpClient;

  public List<Stock> getAllStocks() {
    return httpClient.toBlocking()
        .retrieve(GET("/stocks"), Argument.listOf(Stock.class));
  }
}
