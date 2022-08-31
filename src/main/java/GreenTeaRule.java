import java.util.List;
import java.util.stream.Collectors;

public class GreenTeaRule implements Rule {

    @Override
    public double getDiscount(List<Product> products) {
        List<Product> greenTeaItems = products.stream().filter(product -> "GR1".equals(product.getProductCode())).collect(Collectors.toList());
        if (greenTeaItems.size() > 1) {
            int freeItems = greenTeaItems.size() / 2;
            return greenTeaItems.get(0).getPrice() * freeItems;
        }
        return 0;
    }
}
