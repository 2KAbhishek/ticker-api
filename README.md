## CI/CD Kata

### Application Details

This is a simple Micronaut application that makes requests to a REST API and returns the response.
The server is available [here](https://61deab5cfb8dae0017c2e196.mockapi.io/api/v1/stocks) which serves list of Penny Stocks.

The application is able to get stock information from this API based on a ticker name sent as a query parameter.

The source code for the application along with the test cases is available in this repository.

### Running the application

- To build the project, use `./gradlew build`
- To run all test cases, use `./gradlew test`
- To run gradle task use `./gradlew run`

### Example

```json
// curl $APP-HOST:PORT/tickers/HCC
{
  "ticker": "HCC",
  "name": "Hindustan Construction Company Limited",
  "price": 65.0
}

// curl $APP-HOST:PORT/tickers/TATAMOTORS
{
  "ticker": "TATAMOTORS",
  "name": "TATA MOTORS LIMITED",
  "price": 99
}
```

### Live Version

[Live Link](https://add-your-link.here)

