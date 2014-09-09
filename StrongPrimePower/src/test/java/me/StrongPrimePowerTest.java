package me;

import org.junit.*;
import static org.junit.Assert.*;

public class StrongPrimePowerTest {

    public StrongPrimePowerTest() {}

    @Test
    public void test() throws Exception {
        assertArrayEquals(new int[]{3,3}, StrongPrimePower.baseAndExponent("27"));
        assertArrayEquals(new int[]{2,59}, StrongPrimePower.baseAndExponent("576460752303423488"));
        assertArrayEquals(new int[]{999999937,2}, StrongPrimePower.baseAndExponent("999999874000003969"));
        assertArrayEquals(new int[]{}, StrongPrimePower.baseAndExponent("999999874000003960"));
    }
}
