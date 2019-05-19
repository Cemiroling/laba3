package sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientTest {
    private Client testClient = new Client();

    @Before
    public void setUp() {
        testClient.setMaxAmount(100);
        testClient.setMoney(10000);
        testClient.setName("test");
    }

    @Test
    public void getMaxAmount() {
        int test = testClient.getMaxAmount();
        Assert.assertEquals(100, test);
    }

    @Test
    public void setMaxAmount() {
        testClient.setMaxAmount(101);
        int test = testClient.getMaxAmount();
        Assert.assertEquals(101, test);
    }

    @Test
    public void getName() {
        String test = testClient.getName();
        Assert.assertEquals("test", test);
    }

    @Test
    public void setName() {
        testClient.setName("test1");
        String test = testClient.getName();
        Assert.assertEquals("test1", test);
    }

    @Test
    public void setMoney() {
        testClient.setMoney(10010);
        int test = testClient.getMoney();
        Assert.assertEquals(10010, test);
    }

    @Test
    public void getMoney() {
        int test = testClient.getMoney();
        Assert.assertEquals(10000, test);
    }

    @Test
    public void makeOrder() {
        Order testOrder = new Order(1, "test", 20);
        testOrder.set_state(false);
        testClient.make_order("test", 20);

        Assert.assertEquals(testOrder.get_subject(), ((Order) testClient.getComp().getOrderList().get(0)).get_subject());
        Assert.assertEquals(testOrder.get_amount(), ((Order) testClient.getComp().getOrderList().get(0)).get_amount());
        Assert.assertEquals(testOrder.get_state(), ((Order) testClient.getComp().getOrderList().get(0)).get_state());
        Assert.assertEquals(testOrder.get_number(), ((Order) testClient.getComp().getOrderList().get(0)).get_number());
    }

    @Test
    public void PayOrder() {
        testClient.make_order("test", 10);
        testClient.PayOrder();
        int testmoney = testClient.getMoney();
        boolean teststate = ((Order) testClient.getComp().getOrderList().get(0)).get_state();

        Assert.assertEquals(true, teststate);
        Assert.assertEquals(9000, testmoney);
    }

    @Test
    public void getComp() {
        Order testOrder = new Order(1, "test", 20);
        testClient.make_order("test", 20);
        Company test = testClient.getComp();

        Assert.assertEquals(testOrder.get_number(), ((Order) test.getOrderList().get(0)).get_number());
        Assert.assertEquals(testOrder.get_subject(), ((Order) test.getOrderList().get(0)).get_subject());
        Assert.assertEquals(testOrder.get_amount(), ((Order) test.getOrderList().get(0)).get_amount());
        Assert.assertEquals(testOrder.get_state(), ((Order) test.getOrderList().get(0)).get_state());
    }
}
