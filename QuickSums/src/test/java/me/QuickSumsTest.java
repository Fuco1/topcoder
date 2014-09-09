package me;

import org.junit.*;
import static org.junit.Assert.*;

public class QuickSumsTest {

    public QuickSumsTest() {}

    @Test
    public void testMinSums() throws Exception {
        assertEquals(4, QuickSums.minSums("99999", 45));
        assertEquals(4, QuickSums.minSums("99999", 45));
        assertEquals(3, QuickSums.minSums("1110", 3));
        assertEquals(8, QuickSums.minSums("0123456789", 45));
        assertEquals(-1, QuickSums.minSums("99999", 100));
        assertEquals(2, QuickSums.minSums("382834", 100));
        assertEquals(4, QuickSums.minSums("9230560001", 71));
        assertEquals(0, QuickSums.minSums("0000000000", 0));
        assertEquals(2, QuickSums.minSums("111", 3));
        assertEquals(9, QuickSums.minSums("1111111111", 10));
        assertEquals(9, QuickSums.minSums("1212121212", 15));
        assertEquals(9, QuickSums.minSums("1213121712", 21));
        assertEquals(6, QuickSums.minSums("0123456789", 81));
        assertEquals(-1, QuickSums.minSums("8833614925", 100));
        assertEquals(-1, QuickSums.minSums("0525222922", 93));
        assertEquals(-1, QuickSums.minSums("3769558148", 99));
        assertEquals(-1, QuickSums.minSums("1210102121", 100));
        assertEquals(4, QuickSums.minSums("0220120200", 63));
        assertEquals(0, QuickSums.minSums("0000000001", 1));
        assertEquals(1, QuickSums.minSums("1000000000", 1));
        assertEquals(1, QuickSums.minSums("1000000001", 2));
        assertEquals(1, QuickSums.minSums("1000000001", 11));
        assertEquals(2, QuickSums.minSums("1001098", 100));
        assertEquals(-1, QuickSums.minSums("99999", 100));
        assertEquals(2, QuickSums.minSums("382834", 100));
        assertEquals(3, QuickSums.minSums("1110", 3));
        assertEquals(0, QuickSums.minSums("1", 1));
    }

    // @Test
    // public void testMinSums2() throws Exception {
    //     assertEquals(4, QuickSums.minSums2("99999", 45));
    //     assertEquals(4, QuickSums.minSums2("99999", 45));
    //     assertEquals(3, QuickSums.minSums2("1110", 3));
    //     assertEquals(8, QuickSums.minSums2("0123456789", 45));
    //     assertEquals(-1, QuickSums.minSums2("99999", 100));
    //     assertEquals(2, QuickSums.minSums2("382834", 100));
    //     assertEquals(4, QuickSums.minSums2("9230560001", 71));
    //     assertEquals(0, QuickSums.minSums2("0000000000", 0));
    //     assertEquals(2, QuickSums.minSums2("111", 3));
    //     assertEquals(9, QuickSums.minSums2("1111111111", 10));
    //     assertEquals(9, QuickSums.minSums2("1212121212", 15));
    //     assertEquals(9, QuickSums.minSums2("1213121712", 21));
    //     assertEquals(6, QuickSums.minSums2("0123456789", 81));
    //     assertEquals(-1, QuickSums.minSums2("8833614925", 100));
    //     assertEquals(-1, QuickSums.minSums2("0525222922", 93));
    //     assertEquals(-1, QuickSums.minSums2("3769558148", 99));
    //     assertEquals(-1, QuickSums.minSums2("1210102121", 100));
    //     assertEquals(4, QuickSums.minSums2("0220120200", 63));
    //     assertEquals(0, QuickSums.minSums2("0000000001", 1));
    //     assertEquals(1, QuickSums.minSums2("1000000000", 1));
    //     assertEquals(1, QuickSums.minSums2("1000000001", 2));
    //     assertEquals(1, QuickSums.minSums2("1000000001", 11));
    //     assertEquals(2, QuickSums.minSums2("1001098", 100));
    //     assertEquals(-1, QuickSums.minSums2("99999", 100));
    //     assertEquals(2, QuickSums.minSums2("382834", 100));
    //     assertEquals(3, QuickSums.minSums2("1110", 3));
    //     assertEquals(0, QuickSums.minSums2("1", 1));
    // }
}
