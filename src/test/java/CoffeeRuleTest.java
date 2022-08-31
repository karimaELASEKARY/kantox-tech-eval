import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

public class CoffeeRuleTest {


    public static CoffeeRule coffeeRule = new CoffeeRule();

    @Test
    public void testRuleWithEmptyProductsList() {
        double actualDiscount = coffeeRule.getDiscount(new ArrayList<>());
        Assert.assertEquals(0, Double.compare(actualDiscount, 0));
    }

    @Test
    public void testRuleWithoutDiscount() {
        double actualDiscount = coffeeRule.getDiscount(Arrays.asList(
                new Product("CF1", 11.23, "£"),
                new Product("CF1", 11.23, "£")));
        actualDiscount = new BigDecimal(actualDiscount).setScale(2, RoundingMode.HALF_UP).doubleValue();
        Assert.assertEquals(0, Double.compare(0, actualDiscount));

    }

    @Test
    public void testRuleWithDiscount() {
        double actualDiscount = coffeeRule.getDiscount(Arrays.asList(
                new Product("CF1", 11.23, "£"),
                new Product("CF1", 11.23, "£"),
                new Product("CF1", 11.23, "£")));
        actualDiscount = new BigDecimal(actualDiscount).setScale(2, RoundingMode.HALF_UP).doubleValue();
        double expectedDiscount = 11.23;
        Assert.assertEquals(0, Double.compare(expectedDiscount, actualDiscount));

    }

}
