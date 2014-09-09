package me;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class BinaryHeapTest {

    public BinaryHeapTest() {}

    private BinaryHeap<Integer> h;

    @Before
    public void setUp() {
        h = new BinaryHeap<Integer>();
    }

    @Test
    public void insertTest() throws Exception {
        h.insert(4);
        h.insert(3);
        h.insert(2);
        h.insert(1);
        assertEquals(4, h.size());

        try {
            h.insert(null);
            fail("Inserted null");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void getMinTest() throws Exception {
        h.insert(4);
        assertEquals(new Integer(4), h.getMin());
        h.insert(5);
        assertEquals(new Integer(4), h.getMin());
        h.insert(2);
        assertEquals(new Integer(2), h.getMin());
        h.insert(3);
        assertEquals(new Integer(2), h.getMin());
        h.insert(1);
        assertEquals(new Integer(1), h.getMin());
    }

    @Test
    public void deleteMinTest() throws Exception {
        int[] data = {4,5,2,3,1};
        for (int i : data) {
            h.insert(i);
        }
        List<Integer> l = new ArrayList<Integer>();
        for (int i : data) {
            l.add(h.deleteMin());
        }
        assertEquals(new Integer[]{1,2,3,4,5}, l.toArray());

        data = new int[]{4,6,8,2,4,1,9,3,0};
        for (int i : data) {
            h.insert(i);
        }
        l = new ArrayList<Integer>();
        for (int i : data) {
            l.add(h.deleteMin());
        }
        assertEquals(new Integer[]{0,1,2,3,4,4,6,8,9}, l.toArray());
    }
}
