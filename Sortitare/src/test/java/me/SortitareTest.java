package me;

import org.junit.*;
import static org.junit.Assert.*;

public class SortitareTest {

    public SortitareTest() {}

    @Test
    public void test() throws Exception {
        assertEquals(4, Sortitare.turns(new int[]{25,19,41,36,28,40}, new int[]{27,36,24,39,30}));
        assertEquals(5, Sortitare.turns(new int[]{40,50,60,70,1}, new int[]{7,6,5,4,3,2}));
        assertEquals(19, Sortitare.turns(new int[]{19,7,23,38,23,90,81,22,71,30,87,32,99,5,80,17,19,43,67,50,88,11}, new int[]{24,89,70,35,55,43,92,10,33,18,8,40,14,22,56,4,98,57,89,31,30,14}));
    }
}
