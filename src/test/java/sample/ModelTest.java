package sample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModelTest {
    private Model testModel;

    @Before
    public void setUp() {
        testModel = new Model();
    }

    @Test
    public void IsNumeric() {
        boolean actual = testModel.checkNumeric("100");
        Assert.assertTrue(actual);

        actual = testModel.checkNumeric("test");
        Assert.assertFalse(actual);
    }

    @Test
    public void IsEnter() {
        boolean actual = testModel.checkEmpty("");
        Assert.assertFalse(actual);

        actual = testModel.checkEmpty("test");
        Assert.assertTrue(actual);
    }
}
