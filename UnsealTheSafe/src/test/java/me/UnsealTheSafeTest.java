package me;

import org.junit.*;
import static org.junit.Assert.*;

public class UnsealTheSafeTest {

    public UnsealTheSafeTest() {}

    @Test
    public void test() throws Exception {
        assertEquals(26L, UnsealTheSafe.countPasswords(2));
        assertEquals(74L, UnsealTheSafe.countPasswords(3));
        assertEquals(768478331222L, UnsealTheSafe.countPasswords(25));
        assertEquals(210L, UnsealTheSafe.countPasswords(4));
        assertEquals(600L, UnsealTheSafe.countPasswords(5));
        assertEquals(1710L, UnsealTheSafe.countPasswords(6));
        assertEquals(4882L, UnsealTheSafe.countPasswords(7));
        assertEquals(13926L, UnsealTheSafe.countPasswords(8));
        assertEquals(39746L, UnsealTheSafe.countPasswords(9));
        assertEquals(113406L, UnsealTheSafe.countPasswords(10));
        assertEquals(323638L, UnsealTheSafe.countPasswords(11));
        assertEquals(923502L, UnsealTheSafe.countPasswords(12));
        assertEquals(2635406L, UnsealTheSafe.countPasswords(13));
        assertEquals(7520334L, UnsealTheSafe.countPasswords(14));
        assertEquals(21460630L, UnsealTheSafe.countPasswords(15));
        assertEquals(61240062L, UnsealTheSafe.countPasswords(16));
        assertEquals(174759014L, UnsealTheSafe.countPasswords(17));
        assertEquals(498693678L, UnsealTheSafe.countPasswords(18));
        assertEquals(1423106470L, UnsealTheSafe.countPasswords(19));
        assertEquals(4060990974L, UnsealTheSafe.countPasswords(20));
        assertEquals(11588718614L, UnsealTheSafe.countPasswords(21));
        assertEquals(33069692814L, UnsealTheSafe.countPasswords(22));
        assertEquals(94369903558L, UnsealTheSafe.countPasswords(23));
        assertEquals(269294999646L, UnsealTheSafe.countPasswords(24));
        assertEquals(2192938314414L, UnsealTheSafe.countPasswords(26));
        assertEquals(6257916269734L, UnsealTheSafe.countPasswords(27));
        assertEquals(17857659623934L, UnsealTheSafe.countPasswords(28));
        assertEquals(50959818439094L, UnsealTheSafe.countPasswords(29));
        assertEquals(145419506315214L, UnsealTheSafe.countPasswords(30));
        assertEquals(145419506315214L, UnsealTheSafe.countPasswords(30));
        assertEquals(50959818439094L, UnsealTheSafe.countPasswords(29));
    }
}
