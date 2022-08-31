import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {

    List<Product> products = new ArrayList<>();
    private Map<String, Rule> rules = new HashMap<>();

    public double getTotalPrice() {

        double totalPrice = 0;

        for (Product product : products) {
            totalPrice = Double.sum(totalPrice, product.getPrice());
        }

        for (Rule rule : rules.values()) {
            double discount = rule.getDiscount(this.products);
            totalPrice = totalPrice - discount;
        }
        return new BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public void addRule(String name, Rule rule) {
        rules.put(name, rule);
    }

    public void removeRule(String name) {
        rules.remove(name);
    }

}
