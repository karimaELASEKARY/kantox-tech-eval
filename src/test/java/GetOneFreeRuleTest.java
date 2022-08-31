import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

public class GetOneFreeRuleTest {
    public static GetOneFreeRule getOneFreeRule = new GetOneFreeRule("YG", 4);

    @Test
    public void testRuleWithDiscount() {
        double actualDiscount = getOneFreeRule.getDiscount(Arrays.asList(
                new Product("YG", 1.11, "£"),
                new Product("YG", 1.11, "£"),
                new Product("YG", 1.11, "£"),
                new Product("YG", 1.11, "£"),
                new Product("YG", 1.11, "£")));
        actualDiscount = new BigDecimal(actualDiscount).setScale(2, RoundingMode.HALF_UP).doubleValue();
        double expectedDiscount = 1.11;
        Assert.assertEquals(0, Double.compare(expectedDiscount, actualDiscount));
    }

    @Test
    public void testRuleWithoutDiscount() {
        double actualDiscount = getOneFreeRule.getDiscount(Arrays.asList(
                new Product("YG", 1.11, "£")));
        double expectedDiscount = 0;
        Assert.assertEquals(0, Double.compare(expectedDiscount, actualDiscount));
    }

    @Test
    public void testRuleWithEmptyList() {
        double actualDiscount = getOneFreeRule.getDiscount(new ArrayList<>());
        double expectedDiscount = 0;
        Assert.assertEquals(0, Double.compare(expectedDiscount, actualDiscount));
    }
}
