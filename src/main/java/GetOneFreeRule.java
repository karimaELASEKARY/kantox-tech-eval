import java.util.List;
import java.util.stream.Collectors;

//this is a generic class for get-one-free-rule which can be applied to other products
public class GetOneFreeRule implements Rule {

    private String productCode;
    private int noProducts;

    public GetOneFreeRule(String productCode, int noProducts) {
        this.productCode = productCode;
        this.noProducts = noProducts;
    }

    @Override
    public double getDiscount(List<Product> products) {
        List<Product> greenTeaItems = products.stream().filter(product -> productCode.equals(product.getProductCode())).collect(Collectors.toList());
        if (greenTeaItems.size() > 0) {
            int freeItems = greenTeaItems.size() / (noProducts + 1);
            return greenTeaItems.get(0).getPrice() * freeItems;
        }
        return 0;
    }
}
