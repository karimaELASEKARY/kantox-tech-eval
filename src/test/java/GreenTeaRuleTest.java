import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

public class GreenTeaRuleTest {

    public static GreenTeaRule greenTeaRule = new GreenTeaRule();

    @Test
    public void testRuleWithDiscount() {
        double actualDiscount = greenTeaRule.getDiscount(Arrays.asList(
                new Product("GR1", 3.11, "£"),
                new Product("GR1", 3.11, "£"),
                new Product("GR1", 3.11, "£")));
        actualDiscount = new BigDecimal(actualDiscount).setScale(2, RoundingMode.HALF_UP).doubleValue();
        double expectedDiscount = 3.11;
        Assert.assertEquals(0, Double.compare(expectedDiscount, actualDiscount));
    }

    @Test
    public void testRuleWithoutDiscount() {
        double actualDiscount = greenTeaRule.getDiscount(Arrays.asList(new Product("GR1", 3.11, "£")));
        double expectedDiscount = 0;
        Assert.assertEquals(0, Double.compare(expectedDiscount, actualDiscount));
    }

    @Test
    public void testRuleWithEmptyList() {
        double actualDiscount = greenTeaRule.getDiscount(new ArrayList<>());
        double expectedDiscount = 0;
        Assert.assertEquals(0, Double.compare(expectedDiscount, actualDiscount));
    }


}
