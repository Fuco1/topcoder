package me;

import org.junit.*;
import static org.junit.Assert.*;

public class NewMagicSquareTest {

    public NewMagicSquareTest() {}

    @Test
    public void completeTest() throws Exception {
        assertArrayEquals(new String[]{"01 02 03 04 05", "06 07 08 09 10", "11 12 13 14 15", "16 17 18 19 20", "21 22 23 24 25"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{"01 06 20 21 22", "07 08 09 10 11", "02 03 04 05 12", "13 14 15 16 17", "18 19 23 24 25"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? 20 ?? ??", "?? ?? ?? ?? ??", "?? ?? ?? 05 ??", "?? ?? ?? ?? ??", "?? ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? ??", "?? ?? ?? ?? 24", "?? ?? ?? ?? ??", "?? ?? ?? ?? ??", "21 ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{"01 03 15 17 18", "02 08 09 10 22", "04 05 06 07 23", "11 12 16 24 25", "13 14 19 20 21"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? 15 ?? ??", "02 ?? ?? ?? ??", "?? ?? ?? 07 ??", "?? ?? 16 ?? ??", "?? ?? ?? ?? 21"}));
        assertArrayEquals(new String[]{"01 02 03 04 05", "06 07 08 09 12", "10 11 13 22 23", "14 15 21 24 25", "16 17 18 19 20"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? ??", "?? ?? ?? ?? 12", "?? ?? ?? 22 ??", "?? ?? 21 ?? ??", "?? ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{"01 02 03 04 10", "11 12 13 14 15", "16 17 18 19 20", "21 22 23 24 25", "05 06 07 08 09"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? 04 ??", "?? ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? ?? 23 ?? ??", "?? ?? ?? ?? 09"}));
        assertArrayEquals(new String[]{"01 02 03 08 09", "10 11 12 13 14", "15 16 22 23 24", "04 05 06 07 25", "17 18 19 20 21"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? 03 ?? ??", "?? ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? ?? ?? 07 ??", "?? ?? ?? ?? 21"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? 06 ??", "?? ?? 18 ?? ??", "?? ?? ?? ?? ??", "?? ?? 03 ?? ??", "?? ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? 11", "?? ?? ?? ?? ??", "?? ?? ?? 24 ??", "?? ?? ?? ?? ??", "?? 21 ?? ?? ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? 01 ?? ??", "?? ?? 09 ?? ??", "11 ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? ?? ?? 15 ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? ??", "?? ?? 21 ?? ??", "?? ?? ?? 23 ??", "?? ?? ?? 25 ??", "?? 10 ?? ?? ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"13 ?? ?? ?? ??", "?? 25 ?? ?? ??", "?? ?? ?? ?? ??", "?? 07 ?? ?? ??", "?? 12 ?? ?? ??"}));
        assertArrayEquals(new String[]{"01 02 03 04 05", "06 07 12 13 14", "15 19 20 21 22", "08 09 10 11 16", "17 18 23 24 25"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? 19 ?? ?? ??", "?? ?? ?? 11 ??", "?? ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? 15 ?? ?? ??", "?? ?? ?? ?? ??", "?? ?? 01 ?? ??", "?? ?? ?? 08 ??", "?? ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? 19 ?? ??", "?? ?? 16 ?? ??", "?? ?? ?? 05 ??", "?? ?? ?? ?? ??", "?? ?? 01 ?? ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? 13 ??", "?? 23 ?? ?? ??", "25 ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? 17 ?? ?? ??"}));
        assertArrayEquals(new String[]{"01 02 03 09 12", "10 11 13 14 15", "04 05 06 08 16", "07 17 18 19 20", "21 22 23 24 25"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? 12", "?? ?? ?? ?? ??", "?? ?? ?? 08 ??", "07 ?? ?? ?? ??", "?? ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? ??", "?? ?? ?? ?? 02", "?? ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? ??", "?? ?? ?? 06 ??", "?? 13 ?? ?? ??", "?? ?? ?? ?? ??", "23 ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{"01 12 13 22 23", "02 03 09 10 11", "14 15 20 21 24", "04 05 06 07 08", "16 17 18 19 25"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? ??", "?? ?? ?? ?? 11", "?? ?? ?? 21 ??", "?? ?? ?? ?? 08", "?? ?? ?? 19 ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"25 ?? ?? ?? ??", "?? ?? ?? 01 ??", "?? ?? 14 ?? ??", "?? 22 ?? ?? ??", "?? ?? ?? ?? 15"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? 05 ?? ??", "?? ?? ?? 16 ??", "?? ?? ?? 22 ??", "?? ?? ?? ?? ??", "?? ?? ?? 02 ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? ??", "?? ?? ?? ?? 04", "?? ?? ?? 16 ??", "?? ?? 06 ?? ??", "?? ?? ?? ?? 25"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? 21 ?? ?? ??", "?? ?? ?? 02 ??", "?? ?? 20 ?? ??"}));
        assertArrayEquals(new String[]{"01 02 03 04 10", "05 06 07 08 09", "11 12 13 14 15", "16 17 18 19 20", "21 22 23 24 25"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? 10", "?? ?? ?? ?? 09", "?? ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? ??", "?? ?? 09 ?? ??", "?? ?? ?? ?? ??", "?? ?? 25 ?? ??", "?? ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"05 ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? 22 ?? ?? ??", "?? ?? ?? 02 ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? 25 ?? ??", "?? ?? ?? ?? 07", "08 ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? ?? ?? 14 ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? ??", "?? ?? ?? ?? 22", "?? ?? ?? ?? ??", "?? 23 ?? ?? ??", "?? ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? ??", "?? ?? ?? 13 ??", "?? ?? ?? 04 ??", "?? ?? ?? ?? 19", "?? ?? ?? 06 ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? 03 ??", "?? ?? ?? ?? ??", "?? ?? 09 ?? ??", "?? 16 ?? ?? ??", "?? ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? 07", "21 ?? ?? ?? ??", "23 ?? ?? ?? ??", "?? ?? ?? ?? ??", "15 ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"25 ?? ?? ?? ??", "?? 07 ?? ?? ??", "?? ?? 21 ?? ??", "?? ?? ?? 10 ??", "18 ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{"13 14 16 17 18", "01 02 03 08 09", "04 05 06 07 19", "10 11 12 15 25", "20 21 22 23 24"}, NewMagicSquare.completeTheSquare(new String[]{"13 ?? ?? ?? ??", "?? ?? ?? 08 ??", "?? ?? ?? ?? ??", "?? ?? ?? 15 ??", "?? ?? ?? ?? 24"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? 13 ??", "?? ?? ?? ?? 03", "?? ?? ?? 18 ??", "?? ?? ?? ?? ??", "?? ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{"12 14 15 16 17", "03 04 05 06 09", "13 18 19 20 22", "01 02 07 08 10", "11 21 23 24 25"}, NewMagicSquare.completeTheSquare(new String[]{"12 ?? ?? ?? ??", "?? ?? ?? ?? 09", "13 ?? ?? ?? ??", "?? 02 ?? ?? ??", "?? 21 ?? ?? ??"}));
        assertArrayEquals(new String[]{"01 02 03 04 08", "05 06 07 11 12", "09 10 13 18 19", "20 21 22 23 24", "14 15 16 17 25"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? 08", "?? ?? ?? 11 ??", "?? ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? ?? ?? 17 ??"}));
        assertArrayEquals(new String[]{"01 02 03 04 05", "12 13 17 18 19", "09 14 15 16 20", "06 07 08 10 11", "21 22 23 24 25"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? ??", "?? ?? 17 ?? ??", "09 ?? ?? ?? ??", "?? ?? ?? ?? 11", "?? ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{"01 02 03 04 05", "10 11 12 14 15", "06 07 08 16 17", "18 19 20 21 22", "09 13 23 24 25"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? ??", "10 ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? 13 ?? ?? ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? 02 ??", "?? ?? 01 ?? ??", "?? ?? 22 ?? ??", "?? ?? ?? ?? ??", "?? ?? 09 ?? ??"}));
        assertArrayEquals(new String[]{"01 19 20 21 22", "02 03 04 05 16", "06 07 08 09 15", "10 11 12 13 14", "17 18 23 24 25"}, NewMagicSquare.completeTheSquare(new String[]{"?? 19 ?? ?? ??", "?? ?? ?? ?? ??", "?? ?? ?? ?? 15", "?? ?? ?? ?? 14", "?? ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{"03 04 05 20 22", "06 07 08 09 15", "01 02 23 24 25", "16 17 18 19 21", "10 11 12 13 14"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? 20 ??", "?? ?? ?? ?? ??", "?? 02 ?? ?? ??", "?? ?? ?? ?? 21", "?? ?? ?? ?? 14"}));
        assertArrayEquals(new String[]{"04 14 15 16 17", "05 06 07 08 09", "01 02 03 10 11", "12 13 18 20 21", "19 22 23 24 25"}, NewMagicSquare.completeTheSquare(new String[]{"?? 14 ?? ?? ??", "?? ?? ?? ?? ??", "?? ?? 03 ?? ??", "?? ?? ?? 20 ??", "?? ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? 20 ?? ??", "?? ?? ?? ?? ??", "?? ?? ?? ?? 11", "24 ?? ?? ?? ??", "?? ?? ?? ?? 13"}));
        assertArrayEquals(new String[]{"21 22 23 24 25", "16 17 18 19 20", "11 12 13 14 15", "06 07 08 09 10", "01 02 03 04 05"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? 25", "?? ?? ?? ?? 20", "?? ?? ?? ?? 15", "?? ?? ?? ?? 10", "?? ?? ?? ?? 05"}));
        assertArrayEquals(new String[]{"21 22 23 24 25", "16 17 18 19 20", "11 12 13 14 15", "06 07 08 09 10", "01 02 03 04 05"}, NewMagicSquare.completeTheSquare(new String[]{"21 ?? ?? ?? ??", "16 ?? ?? ?? ??", "11 ?? ?? ?? ??", "06 ?? ?? ?? ??", "01 ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{"04 05 23 24 25", "09 10 18 19 20", "11 12 13 14 15", "06 07 08 16 17", "01 02 03 21 22"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? 23 ?? ??", "?? ?? 18 ?? ??", "?? ?? 13 ?? ??", "?? ?? 08 ?? ??", "?? ?? 03 ?? ??"}));
        assertArrayEquals(new String[]{"01 06 20 21 22", "07 08 09 10 11", "02 03 04 05 12", "13 14 15 16 17", "18 19 23 24 25"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? 20 ?? ??", "?? ?? ?? ?? ??", "?? ?? ?? 05 ??", "?? ?? ?? ?? ??", "?? ?? ?? ?? ??"}));
        assertArrayEquals(new String[]{"01 03 15 17 18", "02 08 09 10 22", "04 05 06 07 23", "11 12 16 24 25", "13 14 19 20 21"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? 15 ?? ??", "02 ?? ?? ?? ??", "?? ?? ?? 07 ??", "?? ?? 16 ?? ??", "?? ?? ?? ?? 21"}));
        assertArrayEquals(new String[]{"06 11 12 24 25", "13 14 15 22 23", "16 17 18 19 20", "07 08 09 10 21", "01 02 03 04 05"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? 24 ??", "?? ?? ?? 22 ??", "?? ?? ?? 19 ??", "?? ?? ?? 10 ??", "?? ?? ?? ?? 05"}));
        assertArrayEquals(new String[]{"21 22 23 24 25", "16 17 18 19 20", "11 12 13 14 15", "06 07 08 09 10", "01 02 03 04 05"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? ??", "?? ?? ?? ?? 20", "?? ?? ?? ?? 15", "?? ?? ?? ?? 10", "?? ?? ?? ?? 05"}));
        assertArrayEquals(new String[]{"21 22 23 24 25", "16 17 18 19 20", "11 12 13 14 15", "06 07 08 09 10", "01 02 03 04 05"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? 25", "?? ?? ?? ?? 20", "?? ?? ?? ?? 15", "?? ?? ?? ?? 10", "?? ?? ?? ?? 05"}));
        assertArrayEquals(new String[]{"01 03 15 16 17", "02 08 09 10 22", "04 05 06 07 23", "11 12 19 24 25", "13 14 18 20 21"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? 15 ?? ??", "02 ?? ?? ?? ??", "?? ?? ?? 07 ??", "?? ?? 19 ?? ??", "?? ?? ?? ?? 21"}));
        assertArrayEquals(new String[]{"06 07 08 09 10", "11 12 13 14 15", "16 17 18 19 20", "21 22 23 24 25", "01 02 03 04 05"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? ?? ?? ?? 05"}));
        assertArrayEquals(new String[]{"05 06 07 11 12", "13 14 15 16 17", "18 19 20 21 22", "08 09 10 23 24", "01 02 03 04 25"}, NewMagicSquare.completeTheSquare(new String[]{"?? ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? ?? ?? ?? ??", "?? ?? 10 ?? ??", "?? ?? ?? 04 ??"}));
    }

}
