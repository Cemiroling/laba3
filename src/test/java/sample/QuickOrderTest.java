package sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuickOrderTest {
    private QuickOrder testOrder;

    @Before
    public void setUp() {
        testOrder = new QuickOrder(10, "test", 20);
    }

    @Test
    public void CheckTime() {
        long test = testOrder.checkTime();
        Assert.assertEquals(86400, test);
    }
}
