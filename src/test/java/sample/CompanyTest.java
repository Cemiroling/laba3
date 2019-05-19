package sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CompanyTest {
    Company testCompany;

    @Before
    public void setUp() {
        testCompany = new Company();
    }

    @Test
    public void CreateOrderAndGetOrderList() {
        testCompany.create_order("test", 10, "test_name");
        Order testOrder = new Order(1, "test", 10);
        testOrder.set_state(false);

        Assert.assertNotNull(testCompany.getOrderList());
        Assert.assertEquals(testOrder.get_number(), ((Order) testCompany.getOrderList().get(0)).get_number());
        Assert.assertEquals(testOrder.get_subject(), ((Order) testCompany.getOrderList().get(0)).get_subject());
        Assert.assertEquals(testOrder.get_amount(), ((Order) testCompany.getOrderList().get(0)).get_amount());
        Assert.assertEquals(testOrder.get_state(), ((Order) testCompany.getOrderList().get(0)).get_state());
    }

    @Test
    public void CancelOrder() {
        testCompany.create_order("test", 10, "test_name");
        testCompany.cancel_order();
        Assert.assertTrue(testCompany.getOrderList().isEmpty());
    }

    @Test
    public void PerformOrder() {
        testCompany.create_order("test", 10, "test_name");
        testCompany.perform_order(1);
        Assert.assertEquals(true, ((Order) testCompany.getOrderList().get(0)).get_state());
    }
}
