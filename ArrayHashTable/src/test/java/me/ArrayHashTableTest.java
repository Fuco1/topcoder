package me;

import org.junit.*;
import static org.junit.Assert.*;

public class ArrayHashTableTest {

    private ArrayHashTable<String, Integer> a;

    public ArrayHashTableTest() {}

    @Before
    public void setUp() {
        // hash from some type with predictable hash so we can test easily
        a = new ArrayHashTable<String, Integer>();
        a.add("Fred", new Integer(1));
        a.add("Bob", new Integer(2));
        a.add("John", new Integer(3));
    }

    @After
    public void tearDown() {
        a = null;
    }

    @Test
    public void addTest() throws Exception {
        assertEquals(3, a.size());
        a.add("Fred", new Integer(4));
        assertEquals(new Integer(4), a.lookup("Fred"));
        assertEquals(3, a.size());
    }

    @Test
    public void lookupTest() throws Exception {
        assertEquals(new Integer(1), a.lookup("Fred"));
        assertEquals(new Integer(2), a.lookup("Bob"));
        assertEquals(new Integer(3), a.lookup("John"));
        assertEquals(null, a.lookup("Lucy"));
        a.remove("Fred");
        assertEquals(new Integer(3), a.lookup("John"));
    }

    @Test
    public void removeTest() throws Exception {
        assertEquals(new Integer(3), a.remove("John"));
        assertEquals(null, a.remove("John"));
        assertEquals(2, a.size());

        assertEquals(new Integer(1), a.remove("Fred"));
        assertEquals(null, a.remove("Fred"));
        assertEquals(1, a.size());
    }

    @Test
    public void removeCollidingTest() throws Exception {
        assertEquals(new Integer(1), a.remove("Fred"));
        assertEquals(null, a.remove("Fred"));
        assertEquals(2, a.size());

        assertEquals(new Integer(3), a.remove("John"));
        assertEquals(null, a.remove("John"));
        assertEquals(1, a.size());
    }

    @Test
    public void removeNonexistantTest() throws Exception {
        assertEquals(null, a.remove("Lucy"));
        assertEquals(3, a.size());
    }
}
