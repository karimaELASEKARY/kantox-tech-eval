
public class Product {
    private String productCode;
    private double price;
    private String currency;

    public Product(String productCode, double price, String currency) {
        this.productCode = productCode;
        this.price = price;
        this.currency = currency;
    }

    public Product(String productCode) {
        this.productCode = productCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}
