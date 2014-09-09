package me;

import org.junit.*;
import static org.junit.Assert.*;

public class MergeSortTest {

    public MergeSortTest() {}

    @Test
    public void mergeTest() throws Exception {
        Integer[] left = {1,3,5};
        Integer[] right = {2,4,6};
        Integer[] re = {1,2,3,4,5,6};
        assertEquals(re, MergeSort.merge(Integer.class, left, right));

        left = new Integer[]{1,2,3};
        right = new Integer[]{4,5,6};
        assertEquals(re, MergeSort.merge(Integer.class, left, right));

        left = new Integer[]{4,5,6};
        right = new Integer[]{1,2,3};
        assertEquals(re, MergeSort.merge(Integer.class, left, right));

        left = new Integer[]{1,4,5};
        right = new Integer[]{2,3,6};
        assertEquals(re, MergeSort.merge(Integer.class, left, right));

        left = new Integer[]{};
        right = new Integer[]{2,4,6};
        assertEquals(new Integer[]{2,4,6}, MergeSort.merge(Integer.class, left, right));

        left = new Integer[]{1,3,5};
        right = new Integer[]{};
        assertEquals(new Integer[]{1,3,5}, MergeSort.merge(Integer.class, left, right));

        left = new Integer[]{1,3,5};
        right = new Integer[]{2,4,6,8,10};
        assertEquals(new Integer[]{1,2,3,4,5,6,8,10}, MergeSort.merge(Integer.class, left, right));

        left = new Integer[]{1,3,5,7,9};
        right = new Integer[]{2,4,6};
        assertEquals(new Integer[]{1,2,3,4,5,6,7,9}, MergeSort.merge(Integer.class, left, right));
    }

    @Test
    public void sortTest() throws Exception {
        Integer[] re = {1,2,3,4,5,6,7};
        Integer[] array = {1,2,3,4,5,6,7};
        assertEquals("Sorted array should stay the same",
                     re, MergeSort.sort(Integer.class, array));

        array = new Integer[]{7,6,5,4,3,2,1};
        assertEquals("Array sorted backwards should sort",
                     re, MergeSort.sort(Integer.class, array));

        array = new Integer[]{4,6,5,2,7,3,1};
        assertEquals("Randomly sorted array should sort",
                     re, MergeSort.sort(Integer.class, array));

        array = new Integer[]{7,6,5,4,3,2,1};
        assertEquals("Array sorted backwards should sort",
                     re, MergeSort.sort(Integer.class, array));

        array = new Integer[]{1};
        assertEquals("Single element should stay as it is",
                     new Integer[]{1}, MergeSort.sort(Integer.class, array));

        array = new Integer[]{1,2};
        assertEquals("Two sorted elements should stay sorted",
                     new Integer[]{1,2}, MergeSort.sort(Integer.class, array));

        array = new Integer[]{2,1};
        assertEquals("Two unsorted elements should swap to correct order",
                     new Integer[]{1,2}, MergeSort.sort(Integer.class, array));

        array = new Integer[]{};
        assertEquals("Empty array should sort to empty array",
                     new Integer[]{}, MergeSort.sort(Integer.class, array));
    }

    @Test
    public void mergeInPlaceTest() throws Exception {
        Integer[] array = {1,3,5,2,4,6};
        Integer[] re = MergeSort.mergeInPlace(Integer.class, array, 0, 6);
        assertEquals(new Integer[]{1,2,3,4,5,6}, array);
        assertSame(re, array);

        array = new Integer[]{1,3,5,2,4,6};
        re = MergeSort.mergeInPlace(Integer.class, array, 2, 4);
        assertEquals(new Integer[]{1,3,2,5,4,6}, array);
        assertSame(re, array);
    }

    @Test
    public void sortInPlaceTest() throws Exception {
        Integer[] array = {1,2,3,4,5,6,7};
        Integer[] re = MergeSort.sortInPlace(Integer.class, array, 0, array.length);
        assertEquals("Sorted array should stay the same",
                     array, re);
        assertSame(array, re);

        array = new Integer[]{7,6,5,4,3,2,1};
        re = MergeSort.sortInPlace(Integer.class, array, 0, array.length);
        assertEquals("Array sorted backwards should sort",
                     new Integer[]{1,2,3,4,5,6,7}, re);
        assertSame(array, re);

        array = new Integer[]{4,6,5,2,7,3,1};
        re = MergeSort.sortInPlace(Integer.class, array, 0, array.length);
        assertEquals("Randomly sorted array should sort",
                     new Integer[]{1,2,3,4,5,6,7}, re);
        assertSame(array, re);

        array = new Integer[]{7,6,5,4,3,2,1};
        re = MergeSort.sortInPlace(Integer.class, array, 0, array.length);
        assertEquals("Array sorted backwards should sort",
                     new Integer[]{1,2,3,4,5,6,7}, re);
        assertSame(array, re);

        array = new Integer[]{1};
        re = MergeSort.sortInPlace(Integer.class, array, 0, array.length);
        assertEquals("Single element should stay as it is",
                     new Integer[]{1}, re);
        assertSame(array, re);

        array = new Integer[]{1,2};
        re = MergeSort.sortInPlace(Integer.class, array, 0, array.length);
        assertEquals("Two sorted elements should stay sorted",
                     new Integer[]{1,2}, re);
        assertSame(array, re);

        array = new Integer[]{2,1};
        re = MergeSort.sortInPlace(Integer.class, array, 0, array.length);
        assertEquals("Two unsorted elements should swap to correct order",
                     new Integer[]{1,2}, re);
        assertSame(array, re);

        array = new Integer[]{};
        re = MergeSort.sortInPlace(Integer.class, array, 0, array.length);
        assertEquals("Empty array should sort to empty array",
                     new Integer[]{}, re);
        assertSame(array, re);
    }


}
