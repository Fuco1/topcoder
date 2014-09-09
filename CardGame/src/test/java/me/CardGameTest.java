package me;

import org.junit.*;
import static org.junit.Assert.*;

public class CardGameTest {

    public CardGameTest() {}

    @Test
    public void testHands() throws Exception {
        assertEquals(30, CardGame.hand(new int[]{3,6,2,8}, 3));
        assertEquals(400, CardGame.hand(new int[]{10,20,30,40,50}, 2));
        assertEquals(103, CardGame.hand(new int[]{0,1,2,3,5,8}, 4));
        assertEquals(1122, CardGame.hand(new int[]{1069, 1122}, 2));
    }

}
