import java.util.List;
import java.util.stream.Collectors;

public class StrawberriesRule implements Rule {
    @Override
    public double getDiscount(List<Product> products) {
        List<Product> strawberriesItems = products.stream().filter(product -> "SR1".equals(product.getProductCode())).collect(Collectors.toList());
        if (strawberriesItems.size() > 2) {
            return strawberriesItems.size() * 0.50d;
        }
        return 0;
    }
}
