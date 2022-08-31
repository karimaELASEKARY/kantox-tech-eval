import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

public class StrawberriesRuleTest {

    public static StrawberriesRule strawberriesRule = new StrawberriesRule();

    @Test
    public void testRuleWithEmptyProductsList() {
        double actualDiscount = strawberriesRule.getDiscount(new ArrayList<>());
        Assert.assertEquals(0, Double.compare(actualDiscount, 0));
    }

    @Test
    public void testRuleWithoutDiscount() {
        double actualDiscount = strawberriesRule.getDiscount(Arrays.asList(new Product("SR1", 5.00, "£"),
                new Product("SR1", 5.00, "£")));
        actualDiscount = new BigDecimal(actualDiscount).setScale(2, RoundingMode.HALF_UP).doubleValue();
        Assert.assertEquals(0, Double.compare(0, actualDiscount));

    }

    @Test
    public void testRuleWithDiscount() {
        double actualDiscount = strawberriesRule.getDiscount(Arrays.asList(
                new Product("SR1", 5.00, "£"),
                new Product("SR1", 5.00, "£"),
                new Product("SR1", 5.00, "£")));
        actualDiscount = new BigDecimal(actualDiscount).setScale(2, RoundingMode.HALF_UP).doubleValue();
        double expectedDiscount = 1.50;
        Assert.assertEquals(0, Double.compare(expectedDiscount, actualDiscount));

    }

}
