package service;

import org.junit.Assert;
import org.junit.Test;

public class ExchangeTest {
    @Test(expected = RuntimeException.class)
    public void number_lesser_than_0_1() {
        Exchanger.findMaxValue(-1);
    }

    @Test(expected = RuntimeException.class)
    public void number_lesser_than_0_2() {
        Exchanger.findMaxValue(2000000000);
    }

    @Test
    public void number_lesser_than_12_1() {
        Assert.assertEquals(10, Exchanger.findMaxValue(10));
    }

    @Test
    public void number_lesser_than_12_2() {
        Assert.assertEquals(11, Exchanger.findMaxValue(11));
    }

    @Test
    public void number_greater_than_12_1() {
        Assert.assertEquals(13, Exchanger.findMaxValue(12));
    }

    @Test
    public void number_greater_than_12_2() {
        Assert.assertEquals(4243218150L, Exchanger.findMaxValue(1000000000));
    }

    @Test
    public void number_greater_than_12_3() {
        Assert.assertEquals(27, Exchanger.findMaxValue(25));
    }

    @Test
    public void number_greater_than_12_4() {
        Assert.assertEquals(689, Exchanger.findMaxValue(520));
    }
}
