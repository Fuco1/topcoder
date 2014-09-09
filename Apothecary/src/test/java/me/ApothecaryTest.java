package me;

import org.junit.*;
import static org.junit.Assert.*;

public class ApothecaryTest {

    @Test
    public void test() throws Exception {
        assertArrayEquals(new int[]{-9, -1, 27}, Apothecary.balance(17));
        assertArrayEquals(new int[]{1}, Apothecary.balance(1));
        assertArrayEquals(new int[]{-243, -9, 81, 2187}, Apothecary.balance(2016));
        assertArrayEquals(new int[]{-531441, -59049, -6561, -243, -27, 1, 81, 729, 2187, 1594323}, Apothecary.balance(1000000));
        assertArrayEquals(new int[]{-1, 3}, Apothecary.balance(2));
        assertArrayEquals(new int[]{3}, Apothecary.balance(3));
        assertArrayEquals(new int[]{1, 3}, Apothecary.balance(4));
        assertArrayEquals(new int[]{-3, -1, 9}, Apothecary.balance(5));
        assertArrayEquals(new int[]{-3, 9}, Apothecary.balance(6));
        assertArrayEquals(new int[]{-3, 1, 9}, Apothecary.balance(7));
        assertArrayEquals(new int[]{-1, 9}, Apothecary.balance(8));
        assertArrayEquals(new int[]{9}, Apothecary.balance(9));
        assertArrayEquals(new int[]{-9, -3, -1, 27}, Apothecary.balance(14));
        assertArrayEquals(new int[]{-9, 1, 3, 27}, Apothecary.balance(22));
        assertArrayEquals(new int[]{-27, -9, 81}, Apothecary.balance(45));
        assertArrayEquals(new int[]{3, 81}, Apothecary.balance(84));
        assertArrayEquals(new int[]{-81, -9, 3, 243}, Apothecary.balance(156));
        assertArrayEquals(new int[]{-9, 1, 81, 243}, Apothecary.balance(316));
        assertArrayEquals(new int[]{-243, -9, -3, -1, 27, 729}, Apothecary.balance(500));
        assertArrayEquals(new int[]{-81, -9, -1, 3, 27, 243, 729}, Apothecary.balance(911));
        assertArrayEquals(new int[]{-243, -9, -1, 3, 27, 81, 2187}, Apothecary.balance(2045));
        assertArrayEquals(new int[]{-2187, -81, -27, -9, 1, 729, 6561}, Apothecary.balance(4987));
        assertArrayEquals(new int[]{-729, -27, -9, -3, 243, 2187, 19683}, Apothecary.balance(21345));
        assertArrayEquals(new int[]{-6561, -2187, -729, -243, -3, 1, 9, 81, 19683, 59049}, Apothecary.balance(69100));
        assertArrayEquals(new int[]{-59049, -19683, -243, -81, 3, 729, 2187, 177147}, Apothecary.balance(101010));
        assertArrayEquals(new int[]{-177147, -59049, -19683, -2187, -729, -243, -9, 27, 6561, 531441}, Apothecary.balance(278982));
        assertArrayEquals(new int[]{-177147, -19683, -81, -9, 1, 3, 27, 2187, 6561, 59049, 531441}, Apothecary.balance(402349));
        assertArrayEquals(new int[]{-59049, -2187, -243, -81, 3, 729, 6561, 177147, 531441}, Apothecary.balance(654321));
        assertArrayEquals(new int[]{-729, -9, 3, 27, 81, 243, 2187, 19683, 59049, 177147, 531441}, Apothecary.balance(789123));
        assertArrayEquals(new int[]{-531441, -59049, -6561, -243, -27, 81, 729, 2187, 1594323}, Apothecary.balance(999999));
        assertArrayEquals(new int[]{531441}, Apothecary.balance(531441));
        assertArrayEquals(new int[]{-531441, -177147, -59049, -19683, -6561, -243, -27, -9, -3, 1, 81, 729, 2187, 1594323}, Apothecary.balance(803158));
        assertArrayEquals(new int[]{-531441, -177147, -59049, -19683, -6561, -2187, -729, -243, -81, -9, -3, -1, 1594323}, Apothecary.balance(797189));
        assertArrayEquals(new int[]{1, 3, 9, 81}, Apothecary.balance(94));
        assertArrayEquals(new int[]{-81, -9, -3, -1, 243, 2187, 6561, 19683, 59049}, Apothecary.balance(87629));
        assertArrayEquals(new int[]{-531441, -177147, -19683, -729, -81, -9, -1, 27, 243, 6561, 59049, 1594323}, Apothecary.balance(931112));
        assertArrayEquals(new int[]{-6561, -729, -9, 3, 81, 2187, 19683, 177147, 531441}, Apothecary.balance(723243));
        assertArrayEquals(new int[]{-243, -9, 81, 2187}, Apothecary.balance(2016));
        assertArrayEquals(new int[]{1, 3}, Apothecary.balance(4));
        assertArrayEquals(new int[]{-531441, -59049, -6561, -243, -27, 1, 81, 729, 2187, 1594323}, Apothecary.balance(1000000));
        assertArrayEquals(new int[]{3, 9}, Apothecary.balance(12));
    }
}
