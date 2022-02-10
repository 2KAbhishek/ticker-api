package co.incubyte.posts;

import static io.micronaut.http.HttpRequest.GET;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
class StockIntegrationTest {

  @Inject
  @Client("/tickers")
  private HttpClient httpClient;

  @Test
  void ticker_search_should_return_stock_info() {
    Stock stock = httpClient.toBlocking()
        .retrieve(GET("/HCC"), Argument.of(Stock.class), Argument.of(Exception.class));
    assertEquals("HCC", stock.getTicker());
  }

  @Test
  void status_code_404_for_no_sticker_found() {
    HttpClientResponseException httpClientResponseException =
        assertThrows(
            HttpClientResponseException.class,
            () -> httpClient.toBlocking().exchange(GET("/jio"),
                Argument.of(Stock.class)));
    assertEquals(HttpStatus.NOT_FOUND, httpClientResponseException.getStatus());
  }
}
