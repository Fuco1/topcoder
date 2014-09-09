package me;

import org.junit.*;
import static org.junit.Assert.*;

public class RedundantStringsTest {

    public RedundantStringsTest() {}

    @Test
    public void test() throws Exception {
        assertEquals(1074793396, RedundantStrings.howMany(60));
        assertEquals(0, RedundantStrings.howMany(1));
        assertEquals(2, RedundantStrings.howMany(2));
        assertEquals(4, RedundantStrings.howMany(4));
        assertEquals(536870914, RedundantStrings.howMany(58));
        assertEquals(2, RedundantStrings.howMany(59));
        assertEquals(34, RedundantStrings.howMany(10));
        assertEquals(33814, RedundantStrings.howMany(30));
        assertEquals(0, RedundantStrings.howMany(1));
        assertEquals(2, RedundantStrings.howMany(2));
        assertEquals(2, RedundantStrings.howMany(3));
        assertEquals(4, RedundantStrings.howMany(4));
        assertEquals(2, RedundantStrings.howMany(5));
        assertEquals(10, RedundantStrings.howMany(6));
        assertEquals(2, RedundantStrings.howMany(7));
        assertEquals(16, RedundantStrings.howMany(8));
        assertEquals(8, RedundantStrings.howMany(9));
        assertEquals(34, RedundantStrings.howMany(10));
        assertEquals(2, RedundantStrings.howMany(11));
        assertEquals(76, RedundantStrings.howMany(12));
        assertEquals(2, RedundantStrings.howMany(13));
        assertEquals(130, RedundantStrings.howMany(14));
        assertEquals(38, RedundantStrings.howMany(15));
        assertEquals(256, RedundantStrings.howMany(16));
        assertEquals(2, RedundantStrings.howMany(17));
        assertEquals(568, RedundantStrings.howMany(18));
        assertEquals(2, RedundantStrings.howMany(19));
        assertEquals(1036, RedundantStrings.howMany(20));
        assertEquals(134, RedundantStrings.howMany(21));
        assertEquals(2050, RedundantStrings.howMany(22));
        assertEquals(2, RedundantStrings.howMany(23));
        assertEquals(4336, RedundantStrings.howMany(24));
        assertEquals(32, RedundantStrings.howMany(25));
        assertEquals(8194, RedundantStrings.howMany(26));
        assertEquals(512, RedundantStrings.howMany(27));
        assertEquals(16396, RedundantStrings.howMany(28));
        assertEquals(2, RedundantStrings.howMany(29));
        assertEquals(33814, RedundantStrings.howMany(30));
        assertEquals(2, RedundantStrings.howMany(31));
        assertEquals(65536, RedundantStrings.howMany(32));
        assertEquals(2054, RedundantStrings.howMany(33));
        assertEquals(131074, RedundantStrings.howMany(34));
        assertEquals(158, RedundantStrings.howMany(35));
        assertEquals(266176, RedundantStrings.howMany(36));
        assertEquals(2, RedundantStrings.howMany(37));
        assertEquals(524290, RedundantStrings.howMany(38));
        assertEquals(8198, RedundantStrings.howMany(39));
        assertEquals(1048816, RedundantStrings.howMany(40));
        assertEquals(2, RedundantStrings.howMany(41));
        assertEquals(2113462, RedundantStrings.howMany(42));
        assertEquals(2, RedundantStrings.howMany(43));
        assertEquals(4194316, RedundantStrings.howMany(44));
        assertEquals(33272, RedundantStrings.howMany(45));
        assertEquals(8388610, RedundantStrings.howMany(46));
        assertEquals(2, RedundantStrings.howMany(47));
        assertEquals(16842496, RedundantStrings.howMany(48));
        assertEquals(128, RedundantStrings.howMany(49));
        assertEquals(33555424, RedundantStrings.howMany(50));
        assertEquals(131078, RedundantStrings.howMany(51));
        assertEquals(67108876, RedundantStrings.howMany(52));
        assertEquals(2, RedundantStrings.howMany(53));
        assertEquals(134479360, RedundantStrings.howMany(54));
        assertEquals(2078, RedundantStrings.howMany(55));
        assertEquals(268435696, RedundantStrings.howMany(56));
        assertEquals(524294, RedundantStrings.howMany(57));
        assertEquals(536870914, RedundantStrings.howMany(58));
        assertEquals(2, RedundantStrings.howMany(59));
        assertEquals(1074793396, RedundantStrings.howMany(60));
        assertEquals(2078, RedundantStrings.howMany(55));
        assertEquals(1074793396, RedundantStrings.howMany(60));
        assertEquals(2, RedundantStrings.howMany(5));
        assertEquals(256, RedundantStrings.howMany(16));
        assertEquals(33814, RedundantStrings.howMany(30));
        assertEquals(8, RedundantStrings.howMany(9));
        assertEquals(16, RedundantStrings.howMany(8));
        assertEquals(65536, RedundantStrings.howMany(32));
    }
}
