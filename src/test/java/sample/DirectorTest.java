package sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DirectorTest {
    private Director testDirector = new Director();

    @Before
    public void setUp() {
        testDirector.setName("test");
    }

    @Test
    public void setName() {
        testDirector.setName("test1");
        String test = testDirector.getName();
        Assert.assertEquals("test1", test);
    }

    @Test
    public void getName() {
        String test = testDirector.getName();
        Assert.assertEquals("test", test);
    }

    @Test
    public void createCompany() {
        testDirector.createCompany(100, 100, "test");
        Assert.assertEquals(100, testDirector.getComp().getMoney());
        Assert.assertEquals(100, testDirector.getComp().getPlan());
        Assert.assertEquals("test", testDirector.getComp().getName());
    }

    @Test
    public void changeCompanyName() {
        testDirector.createCompany(100, 100, "test");
        testDirector.changeCompanyName("test1");
        Assert.assertEquals("test1", testDirector.getComp().getName());
    }

    @Test
    public void changeCompanyPlan() {
        testDirector.createCompany(100, 100, "test");
        testDirector.changeCompanyPlan(1000);
        Assert.assertEquals(1000, testDirector.getComp().getPlan());
    }
}
