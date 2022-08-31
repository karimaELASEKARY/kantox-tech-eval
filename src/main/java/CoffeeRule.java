import java.util.List;
import java.util.stream.Collectors;

public class CoffeeRule implements Rule {
    @Override
    public double getDiscount(List<Product> products) {
        List<Product> coffeeItems = products.stream().filter(product -> "CF1".equals(product.getProductCode())).collect(Collectors.toList());
        if (coffeeItems.size() > 2) {
            double totalPrice = coffeeItems.stream().mapToDouble(Product::getPrice).sum();
            return totalPrice / 3;
        }
        return 0;
    }
}
