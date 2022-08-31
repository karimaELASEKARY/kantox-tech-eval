import org.junit.*;

//this is the integration test for the cashier function
public class CashierTest {

    public static Basket normalBasket = new Basket() {{
        products.add(new Product("GR1", 3.11, "£"));
        products.add(new Product("SR1", 5.00, "£"));
        products.add(new Product("CF1", 11.23, "£"));
    }};

    public static Basket rule1Basket = new Basket() {{
        products.add(new Product("GR1", 3.11, "£"));
        products.add(new Product("GR1", 3.11, "£"));
        products.add(new Product("GR1", 3.11, "£"));
        products.add(new Product("GR1", 3.11, "£"));
        products.add(new Product("GR1", 3.11, "£"));
    }};

    public static Basket rule2Basket = new Basket() {{
        products.add(new Product("SR1", 5.00, "£"));
        products.add(new Product("SR1", 5.00, "£"));
        products.add(new Product("SR1", 5.00, "£"));
    }};

    public static Basket rule3Basket = new Basket() {{
        products.add(new Product("CF1", 11.23, "£"));
        products.add(new Product("CF1", 11.23, "£"));
        products.add(new Product("CF1", 11.23, "£"));
    }};

    public static Basket mixedBasket = new Basket() {{
        products.add(new Product("GR1", 3.11, "£"));
        products.add(new Product("GR1", 3.11, "£"));
        products.add(new Product("GR1", 3.11, "£"));
        products.add(new Product("GR1", 3.11, "£"));
        products.add(new Product("GR1", 3.11, "£"));
        products.add(new Product("SR1", 5.00, "£"));
        products.add(new Product("SR1", 5.00, "£"));
        products.add(new Product("SR1", 5.00, "£"));
        products.add(new Product("CF1", 11.23, "£"));
        products.add(new Product("CF1", 11.23, "£"));
        products.add(new Product("CF1", 11.23, "£"));
    }};

    @Test
    public void testTotalPriceWithoutDiscount() {
        double actualTotalPrice = normalBasket.getTotalPrice();
        double expectedTotalPrice = 19.34;
        Assert.assertTrue(expectedTotalPrice == actualTotalPrice);
    }

    @Test
    public void testGreenTeaRuleBasket() {
        rule1Basket.addRule("GR1", new GreenTeaRule());
        double actualTotalPrice = rule1Basket.getTotalPrice();
        double expectedTotalPrice = 9.33;
        Assert.assertTrue(expectedTotalPrice == actualTotalPrice);
    }

    @Test
    public void testStrawberriesRuleBasket() {
        rule2Basket.addRule("SR1", new StrawberriesRule());
        double actualTotalPrice = rule2Basket.getTotalPrice();
        double expectedTotalPrice = 13.50;
        Assert.assertTrue(expectedTotalPrice == actualTotalPrice);
    }

    @Test
    public void testCoffeeRuleBasket() {
        rule3Basket.addRule("CF1", new CoffeeRule());
        double actualTotalPrice = rule3Basket.getTotalPrice();
        double expectedTotalPrice = 22.46;
        Assert.assertTrue(expectedTotalPrice == actualTotalPrice);
    }

    @Test
    public void testCombinedRulesBasket() {
        mixedBasket.addRule("GR1", new GreenTeaRule());
        mixedBasket.addRule("CF1", new CoffeeRule());
        mixedBasket.addRule("SR1", new StrawberriesRule());

        double actualTotalPrice = mixedBasket.getTotalPrice();
        double expectedTotalPrice = 45.29;
        Assert.assertTrue(expectedTotalPrice == actualTotalPrice);
    }


    @Test
    public void testGetOneFreeRuleBasket() {
        rule1Basket.removeRule("GR1");
        rule1Basket.addRule("free-tea-rule", new GetOneFreeRule("GR1", 1));
        double actualTotalPrice = rule1Basket.getTotalPrice();
        double expectedTotalPrice = 9.33;
        Assert.assertTrue(expectedTotalPrice == actualTotalPrice);
    }
}


