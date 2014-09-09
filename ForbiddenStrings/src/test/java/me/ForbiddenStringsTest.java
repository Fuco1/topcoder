package me;

import org.junit.*;
import static org.junit.Assert.*;

public class ForbiddenStringsTest {

    public ForbiddenStringsTest() {}

    @Test
    public void test() throws Exception {
        assertEquals(9L, ForbiddenStrings.countNotForbidden(2));
        assertEquals(21L, ForbiddenStrings.countNotForbidden(3));
        assertEquals(51L, ForbiddenStrings.countNotForbidden(4));
        assertEquals(3L, ForbiddenStrings.countNotForbidden(1));
        assertEquals(123L, ForbiddenStrings.countNotForbidden(5));
        assertEquals(10089L, ForbiddenStrings.countNotForbidden(10));
        assertEquals(67858611L, ForbiddenStrings.countNotForbidden(20));
        assertEquals(456417007497L, ForbiddenStrings.countNotForbidden(30));
        assertEquals(297L, ForbiddenStrings.countNotForbidden(6));
        assertEquals(717L, ForbiddenStrings.countNotForbidden(7));
        assertEquals(1731L, ForbiddenStrings.countNotForbidden(8));
        assertEquals(4179L, ForbiddenStrings.countNotForbidden(9));
        assertEquals(24357L, ForbiddenStrings.countNotForbidden(11));
        assertEquals(58803L, ForbiddenStrings.countNotForbidden(12));
        assertEquals(141963L, ForbiddenStrings.countNotForbidden(13));
        assertEquals(342729L, ForbiddenStrings.countNotForbidden(14));
        assertEquals(827421L, ForbiddenStrings.countNotForbidden(15));
        assertEquals(1997571L, ForbiddenStrings.countNotForbidden(16));
        assertEquals(4822563L, ForbiddenStrings.countNotForbidden(17));
        assertEquals(11642697L, ForbiddenStrings.countNotForbidden(18));
        assertEquals(28107957L, ForbiddenStrings.countNotForbidden(19));
        assertEquals(163825179L, ForbiddenStrings.countNotForbidden(21));
        assertEquals(395508969L, ForbiddenStrings.countNotForbidden(22));
        assertEquals(954843117L, ForbiddenStrings.countNotForbidden(23));
        assertEquals(2305195203L, ForbiddenStrings.countNotForbidden(24));
        assertEquals(5565233523L, ForbiddenStrings.countNotForbidden(25));
        assertEquals(13435662249L, ForbiddenStrings.countNotForbidden(26));
        assertEquals(32436558021L, ForbiddenStrings.countNotForbidden(27));
        assertEquals(78308778291L, ForbiddenStrings.countNotForbidden(28));
        assertEquals(189054114603L, ForbiddenStrings.countNotForbidden(29));
    }
}
