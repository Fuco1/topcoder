package me;

import org.junit.*;
import static org.junit.Assert.*;

public class RockStarTest {

    public RockStarTest() {}

    @Test
    public void test() throws Exception {
        assertEquals(201, RockStar.getNumSongs(0,0,20,200));
        assertEquals(100, RockStar.getNumSongs(100, 0, 0, 200));
        assertEquals(201, RockStar.getNumSongs(0, 0, 20, 200));
        assertEquals(5, RockStar.getNumSongs(1, 2, 1, 1));
        assertEquals(999, RockStar.getNumSongs(192, 279, 971, 249));
        assertEquals(4000, RockStar.getNumSongs(1000, 1000, 1000, 1000));
        assertEquals(100, RockStar.getNumSongs(100, 0, 0, 0));
        assertEquals(1, RockStar.getNumSongs(0, 100, 0, 0));
        assertEquals(1, RockStar.getNumSongs(0, 0, 100, 0));
        assertEquals(100, RockStar.getNumSongs(0, 0, 0, 100));
        assertEquals(737, RockStar.getNumSongs(350, 585, 193, 0));
        assertEquals(1476, RockStar.getNumSongs(304, 711, 174, 823));
        assertEquals(990, RockStar.getNumSongs(989, 147, 0, 0));
        assertEquals(532, RockStar.getNumSongs(532, 0, 0, 119));
        assertEquals(992, RockStar.getNumSongs(57, 451, 166, 602));
        assertEquals(2781, RockStar.getNumSongs(956, 876, 520, 784));
        assertEquals(751, RockStar.getNumSongs(209, 235, 1, 539));
        assertEquals(1925, RockStar.getNumSongs(297, 392, 1000, 844));
        assertEquals(135, RockStar.getNumSongs(0, 56, 92, 23));
        assertEquals(1938, RockStar.getNumSongs(485, 838, 588, 276));
        assertEquals(1662, RockStar.getNumSongs(1, 745, 458, 744));
        assertEquals(1332, RockStar.getNumSongs(225, 361, 609, 385));
        assertEquals(2150, RockStar.getNumSongs(657, 345, 990, 803));
        assertEquals(206, RockStar.getNumSongs(141, 1, 505, 63));
        assertEquals(683, RockStar.getNumSongs(683, 0, 426, 693));
        assertEquals(1709, RockStar.getNumSongs(475, 178, 582, 878));
        assertEquals(2071, RockStar.getNumSongs(756, 569, 405, 504));
        assertEquals(478, RockStar.getNumSongs(0, 835, 1, 475));
        assertEquals(1218, RockStar.getNumSongs(346, 922, 104, 663));
        assertEquals(1217, RockStar.getNumSongs(298, 272, 317, 375));
        assertEquals(2254, RockStar.getNumSongs(891, 398, 762, 567));
        assertEquals(194, RockStar.getNumSongs(194, 0, 573, 0));
        assertEquals(874, RockStar.getNumSongs(1, 123, 198, 627));
        assertEquals(1429, RockStar.getNumSongs(835, 140, 286, 314));
        assertEquals(602, RockStar.getNumSongs(0, 1, 252, 600));
        assertEquals(244, RockStar.getNumSongs(14, 115, 853, 0));
        assertEquals(1087, RockStar.getNumSongs(0, 543, 752, 1));
        assertEquals(1199, RockStar.getNumSongs(533, 232, 290, 202));
        assertEquals(2346, RockStar.getNumSongs(336, 925, 963, 160));
        assertEquals(94, RockStar.getNumSongs(94, 0, 998, 996));
        assertEquals(1702, RockStar.getNumSongs(769, 290, 0, 932));
        assertEquals(1769, RockStar.getNumSongs(635, 466, 604, 202));
        assertEquals(2317, RockStar.getNumSongs(738, 375, 721, 829));
        assertEquals(1635, RockStar.getNumSongs(351, 699, 189, 905));
        assertEquals(1454, RockStar.getNumSongs(149, 691, 612, 80));
        assertEquals(1931, RockStar.getNumSongs(977, 43, 615, 868));
        assertEquals(1423, RockStar.getNumSongs(852, 1, 174, 569));
        assertEquals(820, RockStar.getNumSongs(820, 0, 79, 155));
        assertEquals(1370, RockStar.getNumSongs(323, 501, 299, 448));
        assertEquals(2708, RockStar.getNumSongs(944, 725, 960, 314));
        assertEquals(959, RockStar.getNumSongs(957, 525, 0, 1));
        assertEquals(1, RockStar.getNumSongs(0, 0, 2, 0));
        assertEquals(999, RockStar.getNumSongs(192, 279, 971, 249));
        assertEquals(21, RockStar.getNumSongs(10, 1, 0, 10));
        assertEquals(3764, RockStar.getNumSongs(1000, 888, 889, 988));
        assertEquals(200, RockStar.getNumSongs(0, 0, 0, 200));
        assertEquals(4, RockStar.getNumSongs(1, 1, 1, 1));
        assertEquals(1, RockStar.getNumSongs(0, 0, 0, 1));
        assertEquals(10, RockStar.getNumSongs(0, 0, 0, 10));
        assertEquals(2, RockStar.getNumSongs(0, 1, 0, 1));
        assertEquals(2, RockStar.getNumSongs(0, 0, 100, 1));
        assertEquals(1000, RockStar.getNumSongs(0, 0, 0, 1000));
        assertEquals(40, RockStar.getNumSongs(10, 10, 10, 10));
        assertEquals(2, RockStar.getNumSongs(0, 1, 2, 0));
        assertEquals(24, RockStar.getNumSongs(0, 12, 800, 0));
        assertEquals(3, RockStar.getNumSongs(0, 0, 0, 3));
        assertEquals(11, RockStar.getNumSongs(0, 1, 0, 10));
        assertEquals(4000, RockStar.getNumSongs(1000, 1000, 1000, 1000));
        assertEquals(9, RockStar.getNumSongs(0, 5, 1, 6));
        assertEquals(4, RockStar.getNumSongs(1, 3, 1, 0));
        assertEquals(3, RockStar.getNumSongs(0, 0, 467, 2));
        assertEquals(1, RockStar.getNumSongs(0, 0, 5, 0));
        assertEquals(1, RockStar.getNumSongs(0, 0, 6, 0));
        assertEquals(11, RockStar.getNumSongs(5, 5, 0, 5));
        assertEquals(3, RockStar.getNumSongs(0, 2, 1, 0));
        assertEquals(15, RockStar.getNumSongs(1, 6, 5, 3));
        assertEquals(8, RockStar.getNumSongs(2, 2, 2, 2));
        assertEquals(3, RockStar.getNumSongs(1, 1, 0, 1));
        assertEquals(1, RockStar.getNumSongs(1, 0, 1, 1));
        assertEquals(1816, RockStar.getNumSongs(655, 499, 796, 163));
        assertEquals(1, RockStar.getNumSongs(0, 1, 0, 0));
        assertEquals(3, RockStar.getNumSongs(3, 0, 5, 4));
        assertEquals(10, RockStar.getNumSongs(5, 1, 0, 4));
        assertEquals(1, RockStar.getNumSongs(0, 2, 0, 0));
        assertEquals(3, RockStar.getNumSongs(1, 1, 1, 0));
        assertEquals(3, RockStar.getNumSongs(0, 1, 3, 1));
        assertEquals(3920, RockStar.getNumSongs(980, 980, 980, 980));
    }
}
