package me;

import org.junit.*;
import static org.junit.Assert.*;

public class MaxSumSubseqTest {

    public MaxSumSubseqTest() {}

    @Test
    public void testMss() throws Exception {
        assertEquals(0, MaxSumSubseq.mss(new int[]{-1,-3,-5,-2}));
        assertEquals(19, MaxSumSubseq.mss(new int[]{-1,10,-1,10,-4,-7}));
        assertEquals(22, MaxSumSubseq.mss(new int[]{-1,10,-1,10,-4,7}));
        assertEquals(15, MaxSumSubseq.mss(new int[]{5,10,-1,-10,-4,7}));
        assertEquals(6, MaxSumSubseq.mss(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
