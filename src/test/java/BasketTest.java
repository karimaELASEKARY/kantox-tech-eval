import org.junit.Assert;
import org.junit.Test;

public class BasketTest {

    public static Basket emptyBasket = new Basket();
    public static Basket fullBasket = new Basket() {{
        products.add(new Product("GR1", 3.11, "£"));
        products.add(new Product("GR1", 3.11, "£"));
        products.add(new Product("SR1", 5.00, "£"));
        products.add(new Product("CF1", 11.23, "£"));
    }};

    @Test
    public void testGetTotalPriceWithEmptyProductList() {
        Assert.assertTrue(0 == emptyBasket.getTotalPrice());
    }

    @Test
    public void testGetTotalPriceWithFullBasketWithoutDiscount() {
        double expected = 22.45;
        double actual = fullBasket.getTotalPrice();
        Assert.assertEquals(0, Double.compare(expected, actual));
    }

    @Test
    public void testGetTotalPriceWithFullBasketWithDiscount() {
        fullBasket.addRule("discountRule", (products) -> {
            if (products.stream().mapToDouble(Product::getPrice).sum() > 20)
                return 2;
            return 0;
        });
        double expected = 20.45;
        double actual = fullBasket.getTotalPrice();
        Assert.assertEquals(0, Double.compare(expected, actual));
    }
}
