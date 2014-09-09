package me;

import org.junit.*;
import static org.junit.Assert.*;

public class BettingMoneyTest {

    public BettingMoneyTest() {}

    @Test
    public void gainTest() throws Exception {
        assertEquals(3400, BettingMoney.gain(new int[]{10,20,30},
                                             new int[]{20,30,40},
                                             1));
        assertEquals(49000, BettingMoney.gain(new int[]{200,300,100},
                                              new int[]{10,10,10},
                                              2));
        assertEquals(29500, BettingMoney.gain(new int[]{100,100,100,100},
                                              new int[]{5,5,5,5},
                                              0));
        assertEquals(0, BettingMoney.gain(new int[]{5000,5000},
                                          new int[]{100,2},
                                          0));
        assertEquals(-1000, BettingMoney.gain(new int[]{100},
                                              new int[]{10},
                                              0));
    }
}
