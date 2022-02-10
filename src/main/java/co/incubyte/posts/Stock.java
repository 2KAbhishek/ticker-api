package co.incubyte.posts;

public class Stock {

  private String ticker;
  private String name;
  private double price;

  public Stock() {
    // empty constructor
  }

  public Stock(String ticker, String name, double price) {
    this.ticker = ticker;
    this.name = name;
    this.price = price;
  }

  public String getTicker() {
    return ticker;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Stock{" +
        "ticker='" + ticker + '\'' +
        ", name='" + name + '\'' +
        ", price=" + price +
        '}';
  }
}
