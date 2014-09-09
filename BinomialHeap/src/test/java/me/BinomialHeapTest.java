package me;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class BinomialHeapTest {

    public BinomialHeapTest() {}

    // @Test
    // public void mergeTest() throws Exception {
    //     BinomialHeap<Integer> h1 = new BinomialHeap<Integer>(1);
    //     BinomialHeap<Integer> h2 = new BinomialHeap<Integer>(2);
    //     System.out.println("" + h1);
    //     System.out.println("" + h2);
    //     h1.merge(h2);
    //     System.out.println("" + h1);
    //     h2 = new BinomialHeap<Integer>(3);
    //     h1.merge(h2);
    //     System.out.println("" + h1);
    //     h2 = new BinomialHeap<Integer>(4);
    //     h1.merge(h2);
    //     System.out.println("" + h1);
    //     h1.merge(h1);
    //     System.out.println("" + h1);
    // }

    // @Test
    // public void mergeTreesTest() throws Exception {
    //     BinomialTree<Integer> t1 = new BinomialTree<Integer>(1);
    //     BinomialTree<Integer> t2 = new BinomialTree<Integer>(2);
    //     BinomialTree<Integer> t3 = new BinomialTree<Integer>(3);
    //     BinomialTree<Integer> t4 = new BinomialTree<Integer>(4);
    //     BinomialTree<Integer> re = BinomialTree.merge(t1, t2);
    //     System.out.println("Tree merge test> " + re);
    //     BinomialTree<Integer> re2 = BinomialTree.merge(t3, t4);
    //     System.out.println("Tree merge test> " + re2);
    //     BinomialTree<Integer> re3 = BinomialTree.merge(re, re2);
    //     System.out.println("Tree merge test> " + re3);
    // }

    private BinomialHeap<Integer> h;

    @Before
    public void setUp() {
        h = new BinomialHeap<Integer>();
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
            System.out.println("" + h);
        }
        List<Integer> l = new ArrayList<Integer>();
        for (int i : data) {
            l.add(h.deleteMin());
            System.out.println("" + h);
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
