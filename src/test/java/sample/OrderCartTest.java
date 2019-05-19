package sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderCartTest {
    private OrderCart testOrderCart;

    @Before
    public void setUp() {
        QuickOrder testOrder = new QuickOrder(10, "test", 20);
        testOrder.set_state(true);
        testOrderCart = new OrderCart(testOrder);
        testOrderCart.setName("testName");
    }

    @Test
    public void checkOrderTime() {
        QuickOrder testOrder = new QuickOrder(10, "test", 20);
        String test = testOrderCart.getDate();
        Assert.assertEquals("24h 0m 0s", test);
    }

    @Test
    public void getName() {
        String test = testOrderCart.getName();
        Assert.assertEquals("testName", test);
    }

    @Test
    public void getAmount() {
        int test = testOrderCart.getAmount();
        Assert.assertEquals(20, test);
    }

    @Test
    public void getOrderId() {
        int test = testOrderCart.getOrderId();
        Assert.assertEquals(10, test);
    }

    @Test
    public void getSubject() {
        String test = testOrderCart.getSubject();
        Assert.assertEquals("test", test);
    }

    @Test
    public void isState() {
        String test = testOrderCart.isState();
        Assert.assertEquals("Completed", test);
    }

    @Test
    public void setName() {
        testOrderCart.setName("test1");
        String test = testOrderCart.getName();
        Assert.assertEquals("test1", test);
    }
}
