package me;

import org.junit.*;
import static org.junit.Assert.*;

public class JumperTest {

    public JumperTest() {}

    @Test
    public void minTimeTest() throws Exception {
        assertEquals(5, Jumper.minTime(new String[]{"###..", "..###"}, new int[]{1, 1}, "01"));
        assertEquals(5, Jumper.minTime(new String[]{"###..", "..###"}, new int[]{5, 5}, "01"));
        assertEquals(9, Jumper.minTime(new String[]{"....#", "....#"}, new int[]{4, 5}, "0111"));
        assertEquals(24,Jumper.minTime( new String[]{"#....", "#...."}, new int[]{-4, -5}, "0111"));
        assertEquals(25,Jumper.minTime( new String[]{"##.#.", "####.", "##...", "#.#.#"}, new int[]{1, -1, 2, -2}, "0123012301230123"));
        assertEquals(-1,Jumper.minTime( new String[]{"#####", "#####"}, new int[]{10, 10}, "01"));
        assertEquals(-1,Jumper.minTime( new String[]{"#####", "#####", "....."}, new int[]{1, -1, 1}, "01010101010101010102"));
        assertEquals(3, Jumper.minTime(new String[]{"#####", "####."}, new int[]{1, -1}, "01"));
        assertEquals(12,Jumper.minTime( new String[]{"#....", "#....", "#...."}, new int[]{5, -5, 6}, "2012"));
        assertEquals(57,Jumper.minTime( new String[]{"#....", "#....", "#....", "#####"}, new int[]{5, -5, 6, -1}, "2012320123201232012"));
        assertEquals(35,Jumper.minTime( new String[]{"#.#.#", "#.#.."}, new int[]{6, -3}, "000110101001110011"));
        assertEquals(17,Jumper.minTime( new String[]{".###.", ".#.##", ".##.."}, new int[]{-6, -2, 4}, "2220221120210"));
        assertEquals(28,Jumper.minTime( new String[]{"#...#", "#..#."}, new int[]{4, -2}, "001011100011111011"));
        assertEquals(15,Jumper.minTime( new String[]{".###.", "##...", "#.###"}, new int[]{2, -3, 4}, "0100110202"));
        assertEquals(30,Jumper.minTime( new String[]{".#.##", "#...#", "..#.#"}, new int[]{-1, 3, -6}, "0121000101201000"));
        assertEquals(37,Jumper.minTime( new String[]{"####.", "..###", "....#"}, new int[]{-4, 8, -3}, "20101120101011221"));
        assertEquals(32,Jumper.minTime( new String[]{".#..."}, new int[]{-1}, "000000000000000"));
        assertEquals(46,Jumper.minTime( new String[]{".###.", ".#.##", "...##", "..###"}, new int[]{5, 1, -4, -8}, "22220303301321130020"));
        assertEquals(36,Jumper.minTime( new String[]{"..##.", "###.#", "#...#"}, new int[]{4, 6, -4}, "2212002100021220020"));
        assertEquals(32,Jumper.minTime( new String[]{"##.#.", "###.#"}, new int[]{6, -6}, "10110110001000110"));
        assertEquals(25,Jumper.minTime( new String[]{"..##.", ".###."}, new int[]{-1, 1}, "11100010011010100"));
        assertEquals(31,Jumper.minTime( new String[]{"##.#.", "#.#.."}, new int[]{6, -2}, "000110110111011100"));
        assertEquals(26,Jumper.minTime( new String[]{"#...#", "#.#.."}, new int[]{6, -4}, "0110111001000101111"));
        assertEquals(37,Jumper.minTime( new String[]{".####"}, new int[]{-1}, "000000000000000000"));
        assertEquals(19,Jumper.minTime( new String[]{"...##", ".#.##"}, new int[]{3, -1}, "0011101001011"));
        assertEquals(24,Jumper.minTime( new String[]{"#.###", "#..#.", "##.##", ".####"}, new int[]{1, 1, -5, 8}, "302303012001322"));
        assertEquals(21,Jumper.minTime( new String[]{".###."}, new int[]{1}, "000000000000000000"));
        assertEquals(19,Jumper.minTime( new String[]{"...#.", "#..##"}, new int[]{-3, 7}, "1100001011000011"));
        assertEquals(19,Jumper.minTime( new String[]{".####", "..###"}, new int[]{2, -5}, "0001110101"));
        assertEquals(20,Jumper.minTime( new String[]{"##.#.", "###.#"}, new int[]{-6, 3}, "01111100111"));
        assertEquals(25,Jumper.minTime( new String[]{".#..."}, new int[]{-1}, "00000000000"));
        assertEquals(17,Jumper.minTime( new String[]{"..##.", "#...#", "#..#."}, new int[]{-5, 3, 1}, "22221201212"));
        assertEquals(26,Jumper.minTime( new String[]{"..##.", "#...#"}, new int[]{-7, 5}, "011011001101"));
        assertEquals(35,Jumper.minTime( new String[]{"..#.#"}, new int[]{-1}, "00000000000000000"));
        assertEquals(17,Jumper.minTime( new String[]{".#.##", "##...", ".##.#"}, new int[]{4, 3, -1}, "10201022122"));
        assertEquals(25,Jumper.minTime( new String[]{"####.", ".#...", "##.##", "...##"}, new int[]{7, -3, 8, -2}, "203031003111101"));
        assertEquals(19,Jumper.minTime( new String[]{"###..", "..#..", "##.#."}, new int[]{7, -8, 4}, "0012211022"));
        assertEquals(20,Jumper.minTime( new String[]{"####.", ".##..", ".#.##"}, new int[]{-4, -1, 5}, "12021020021"));
        assertEquals(35,Jumper.minTime( new String[]{"###.#", "..###"}, new int[]{-1, -1}, "11010011110001101"));
        assertEquals(25,Jumper.minTime( new String[]{".####"}, new int[]{-1}, "000000000000"));
        assertEquals(31,Jumper.minTime( new String[]{"##.##", "#.#.#"}, new int[]{9, -4}, "10011110011"));
        assertEquals(24,Jumper.minTime( new String[]{"#.#.#", "###.#"}, new int[]{-1, 1}, "10101100101110100011"));
        assertEquals(24,Jumper.minTime( new String[]{"...#.", "#.###"}, new int[]{-3, 4}, "0011000010"));
        assertEquals(18,Jumper.minTime( new String[]{".#.#."}, new int[]{1}, "000000000000000"));
        assertEquals(39,Jumper.minTime( new String[]{"##..#", ".##.."}, new int[]{3, -6}, "111010001011000"));
        assertEquals(33,Jumper.minTime( new String[]{".##.."}, new int[]{-1}, "0000000000000000"));
        assertEquals(16,Jumper.minTime( new String[]{"#...#", "..###", "...#."}, new int[]{-2, 3, 2}, "011001001010"));
        assertEquals(25,Jumper.minTime( new String[]{"...##"}, new int[]{-1}, "000000000000"));
        assertEquals(20,Jumper.minTime( new String[]{"..###"}, new int[]{1}, "000000000000000000"));
        assertEquals(43,Jumper.minTime( new String[]{"..##.", "##.##", "##.##", "....#"}, new int[]{1, -5, 1, 4}, "1121121022111"));
        assertEquals(194,Jumper.minTime( new String[]{"#....", "..#.."}, new int[]{-3, 1}, "10101010101010101010"));
        assertEquals(-1,Jumper.minTime( new String[]{".#..#"}, new int[]{3}, "0000000000"));
        assertEquals(-1,Jumper.minTime( new String[]{"...#.", "##..."}, new int[]{-8, -1}, "1011110011111010"));
        assertEquals(-1,Jumper.minTime( new String[]{".#.##", "##.##"}, new int[]{-1, -7}, "0000111010001"));
        assertEquals(-1,Jumper.minTime( new String[]{"##.##", "....#", "####.", "##..."}, new int[]{6, -3, 5, -3}, "3211301012212113"));
        assertEquals(-1,Jumper.minTime( new String[]{"...#.", "##.#.", "..###", ".##.#"}, new int[]{-6, -6, 7, -9}, "031021013100300"));
        assertEquals(-1,Jumper.minTime( new String[]{".####", "##.##", "####."}, new int[]{7, 8, -5}, "1120220112200021"));
        assertEquals(-1,Jumper.minTime( new String[]{"#...#"}, new int[]{-10}, "0000000000000000"));
        assertEquals(-1,Jumper.minTime( new String[]{".###.", "....#", "##..#", "..###"}, new int[]{4, -6, -10, 6}, "2331302311033212"));
        assertEquals(-1,Jumper.minTime( new String[]{".#..#"}, new int[]{4}, "0000000000000000"));
        assertEquals(-1,Jumper.minTime( new String[]{"##.#."}, new int[]{3}, "00000000000000"));
        assertEquals(9, Jumper.minTime(new String[]{"#..#.", "...#."}, new int[]{10, -5}, "0111"));
        assertEquals(7, Jumper.minTime(new String[]{"#....", "#...."}, new int[]{1, -1}, "10"));
    }
}
