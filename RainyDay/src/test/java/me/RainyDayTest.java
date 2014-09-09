package me;

import org.junit.*;
import static org.junit.Assert.*;

public class RainyDayTest {

    public RainyDayTest() {}

    @Test
    public void test() throws Exception {
        assertEquals(3, RainyDay.minimumRainTime("Y..H", "R.RR"));
        assertEquals(2, RainyDay.minimumRainTime("Y.C.H", "RRRR."));
        assertEquals(3, RainyDay.minimumRainTime("Y..C.H", "RRR.R."));
        assertEquals(2, RainyDay.minimumRainTime("CCH..Y", "RRRR.R"));
        assertEquals(12, RainyDay.minimumRainTime("Y.C..C...C....C.....C......C.......C........C....H", "RRRRRRRRRRRRR..........RRRRRRRRRRRRRRRRR........RR"));
        assertEquals(96, RainyDay.minimumRainTime("Y................................................H", "RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR"));
        assertEquals(96, RainyDay.minimumRainTime("H................................................Y", "RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR"));
        assertEquals(48, RainyDay.minimumRainTime("H................................................Y", "RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR.RRRRRRRRRRRRRR"));
        assertEquals(6, RainyDay.minimumRainTime("C........................................Y...H...C", "RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR"));
        assertEquals(45, RainyDay.minimumRainTime("Y................................................H", "R...R.R..R.R.RRR.R.R.R.R..RR.R..R.R...R.RRR.R.R.R."));
        assertEquals(0, RainyDay.minimumRainTime("Y.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.CH", "R..R.....RRRRRRR.R.R..R..R..RR.R.R.RRR.RR.RR.RRR.R"));
        assertEquals(0, RainyDay.minimumRainTime("Y.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.CH", "R..RR.RRRRR..RRRRRR.R.RR...R.R.R.RRRRR..RRRRR..R.R"));
        assertEquals(13, RainyDay.minimumRainTime("CCC...C....C.Y..C.C.C.........H...............C...", ".RR..RRRRR.RR.RRR.RRRRRRRRRRRR.RRRRRRRRR.RRRRR.R.R"));
        assertEquals(0, RainyDay.minimumRainTime("HCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCY", "RRRRR.RRRRRRRRRRRR....RRRRRRR..RRRRRRRRRRRRR.RR.RR"));
        assertEquals(19, RainyDay.minimumRainTime("....CC......YCC..CC....C........C...CC...HC.CC....", ".RRRRR.RRRRRRRRR.RR.RRRRR.RRRRRRR...RR.RRRRR..RRRR"));
        assertEquals(0, RainyDay.minimumRainTime("Y..HCC.C..C.C......", "RR......RR.RR.RR.R."));
        assertEquals(13, RainyDay.minimumRainTime(".C.......C.C.Y.C....C...CC.C.......HC...C..C", "RRRRRRRR.R.R..R.RRRRR.RRR.RRRRRRRRRR.R.RRR.R"));
        assertEquals(0, RainyDay.minimumRainTime(".CC.C.......C.YC.C.H.C......C...C", "RRRR..RRR..RR.RR.R.RRRRRRRRRRRRRR"));
        assertEquals(0, RainyDay.minimumRainTime(".......CC..HC..C..C...Y..C..", "RR..RRR.RRR.RR.RRRR.R.RR.R.R"));
        assertEquals(0, RainyDay.minimumRainTime(".....C.C.C.C..C...HC...CC..Y....", "................................"));
        assertEquals(0, RainyDay.minimumRainTime("C....CH...C...C..Y.C.", "RR.R.RR..RR..RRRRRRRR"));
        assertEquals(7, RainyDay.minimumRainTime(".Y....C..HC", ".R.RRRRR.RR"));
        assertEquals(6, RainyDay.minimumRainTime("............CY....H..CC....C.C", "RRRRRR.RRRRRRRRRRR.RRRRR.RRRRR"));
        assertEquals(0, RainyDay.minimumRainTime(".C...CY..HCCC....", "RRR.....RR....R.R"));
        assertEquals(10, RainyDay.minimumRainTime("CYC......C....C..C..C.C.H", "RRR.R.RRRRR..RR.R..R.R..R"));
        assertEquals(0, RainyDay.minimumRainTime("CCHC.CC.CCCCCC.......C......Y.C..C.C.C...", "R.RRR.RRR.RRRR...R.R...R.R.R..R.RR.RRR.R."));
        assertEquals(25, RainyDay.minimumRainTime("...C.....C.C..Y....C..C...........C...H", "RRR..RRRRRRRR.RRRRRRR.R.R.RR.R.RRRRRRRR"));
        assertEquals(1, RainyDay.minimumRainTime("CC..Y.H", "R.RRRRR"));
        assertEquals(2, RainyDay.minimumRainTime("...CC.CC..CC.......C.C.CC.........YCC.....CH..C", ".....R..RRRRRRRRR..RR..R.R.RRRR...R.....R...RR."));
        assertEquals(0, RainyDay.minimumRainTime("...CC..Y.CCCCCH.C..CC.CCC.CC........C.C....", "R.R.R.R....R...R..RRR.R..R.R.R.RR.RR.R.R.RR"));
        assertEquals(8, RainyDay.minimumRainTime("CC.C.CC......YCCC.C..CCC.C.......CCCCC.CC.C.C.HCC", "..RRR..RR.R..RRRRRRRRR..RRR.RRRRRRRRRRR.RRRR.RRRR"));
        assertEquals(0, RainyDay.minimumRainTime("..C..C.......C.C..C...C.HCY.....", "................................"));
        assertEquals(7, RainyDay.minimumRainTime("YC.......HC.......", ".R.R..R.R..RRRRRRR"));
        assertEquals(2, RainyDay.minimumRainTime(".HCC..Y.", "RR.RRRRR"));
        assertEquals(14, RainyDay.minimumRainTime("C.....C.CCY.C...C.CC....C..C.CC..H", "RR.RRRRRRRR.RRRRRRRRRRRRR..RRRRRRR"));
        assertEquals(25, RainyDay.minimumRainTime(".........YC..C.C......C...........CHC......", "RRR.RR.RRR.RRRR.RR.RRRR.R.RRRRRRR.R.RRR..RR"));
        assertEquals(10, RainyDay.minimumRainTime(".C...C.C..Y.C.....CC.C..H", "R.RRRRRR.RRR.RR.RRR.R.RRR"));
        assertEquals(0, RainyDay.minimumRainTime("HY", "RR"));
        assertEquals(0, RainyDay.minimumRainTime("YH.", "RRR"));
        assertEquals(7, RainyDay.minimumRainTime(".Y.CC...C.CCC..CCC..C.C.CC......C..CH.CC...C.C", ".RRRR..RR....RR.RRRR.R..RRRR.R.R.RR..RRRRRR..R"));
        assertEquals(16, RainyDay.minimumRainTime(".CCC.HC.C..C...........C..Y.", "RRRRRRR.R.RRRR.RR.R.RRRRRR.R"));
        assertEquals(8, RainyDay.minimumRainTime("C..Y.C.C.......C.H........C", "RRRRRRR.R...RRRR..RRRRRRRR."));
        assertEquals(0, RainyDay.minimumRainTime("C.CHC.....C..CY.C", "................."));
        assertEquals(10, RainyDay.minimumRainTime("C....CC....CY..C....C.C.HCCC..C...C.....C", ".RRRRRR.RR.RRRRR.RRRRRRRRRRRRRRRRRRRRRRRR"));
        assertEquals(0, RainyDay.minimumRainTime(".....HYC.......C.C...............C", "RR.RRRRR.RR.RR.RRR.RRRRRR.RRRRRRRR"));
        assertEquals(10, RainyDay.minimumRainTime("Y.CC...CC..C.CC.C.C...C..C......C..CC.CCCC..CH..", "RR.RRR.RR.RRRRRRR.RRR.RR.RR.RR.RRR.RRRR....RRR.R"));
        assertEquals(0, RainyDay.minimumRainTime("CC..CC..Y.H...", "R....RR.R..RR."));
        assertEquals(18, RainyDay.minimumRainTime("YC...CCC...C.C.C......CC......H..C.C..C.CC", "..RR..RRRR.R.RRRRRRRR.RR.RR.RRR..RRRRRRRRR"));
        assertEquals(36, RainyDay.minimumRainTime(".C....Y.......C..........C.............C..CH....", "RRRRR.RR.RRRRR..R.RRRRRR...R.RRRRRR.RR.RRRRR...."));
        assertEquals(0, RainyDay.minimumRainTime(".CHY", ".RRR"));
        assertEquals(4, RainyDay.minimumRainTime("Y...H", "RR.RR"));
        assertEquals(19, RainyDay.minimumRainTime("Y...C........H", "RRRRRRRRRR.RRR"));
        assertEquals(25, RainyDay.minimumRainTime("C.............C..C....CY..................CH..", "RR..RRR.RR..RRRRRRR.RRRR..RR.RRRR..RRRRRRRRRRR"));
        assertEquals(0, RainyDay.minimumRainTime("....CC..CC.C..H..C.C.CYCCCC.....C...C...C", ".RRR..RRRRRR..RRRRR..R.R.RRRRR.R.RR.R.R.R"));
        assertEquals(2, RainyDay.minimumRainTime("..CC.....CY.C..C...C.H...", ".R.RRR.R...R..R.RRRR.RR.R"));
        assertEquals(0, RainyDay.minimumRainTime("CCH.........Y", "............."));
        assertEquals(0, RainyDay.minimumRainTime("Y.C..C...C....C.....C......C.......C........C....H", ".................................................."));
        assertEquals(0, RainyDay.minimumRainTime("H....C....C....C....C....C....C....C....C....C...Y", ".................................................."));
        assertEquals(0, RainyDay.minimumRainTime("YHC", "RRR"));
        assertEquals(14, RainyDay.minimumRainTime(".YCC...C.CCC....C.....CC..C..CC.CCC.CCCCCC...C.H.", "RR.RR.R..R.RR.R..RR.RRR..RRRRRRRR.RRRRRRR.R.RRR.."));
        assertEquals(28, RainyDay.minimumRainTime("Y..............C................................H", ".RR....R...RR.R......RR......RRRRR........RRR...R"));
        assertEquals(0, RainyDay.minimumRainTime("CCY.CC..CCH", "RRR....RRRR"));
        assertEquals(5, RainyDay.minimumRainTime("Y......C........C.....................H......C", "R......RR.......RRR...................R......R"));
        assertEquals(6, RainyDay.minimumRainTime(".C..CC.Y..C..CC..C.C.C.C.....C.C.C.....C.C.HCCC", "RR....R.R.R.R...RRR..R.RR..RRR..R.R.R...R.R..RR"));
        assertEquals(23, RainyDay.minimumRainTime(".CHC.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.C.Y", "R.R.R.R.R.R.R.R.R.RRR.R.R.R.R.R.R.R.R.R.R.R.R.R.R."));
        assertEquals(5, RainyDay.minimumRainTime("Y....CC..H", "RR..R..RRR"));
        assertEquals(18, RainyDay.minimumRainTime("CCY...............C...............HCC", "......RRRRRRRRRR.R..R...R....R.....RR"));
        assertEquals(9, RainyDay.minimumRainTime("Y...............H", "....RR...RRR....R"));
        assertEquals(0, RainyDay.minimumRainTime("H.......................Y...............C........C", "RRRRR....RRRRR.R.R.R.R.R.R.R.R.R.R.R.R.R.R.R.R.R.R"));
        assertEquals(4, RainyDay.minimumRainTime("Y....C.........H", "R......R.......R"));
        assertEquals(12, RainyDay.minimumRainTime("H......Y", "RRRRRRRR"));
        assertEquals(6, RainyDay.minimumRainTime("H...Y", "RRRRR"));
        assertEquals(0, RainyDay.minimumRainTime("YH", "RR"));
        assertEquals(55, RainyDay.minimumRainTime("Y..C.C......C.CC......C.C.....C.C......C......H.C", "RRRRR.RRR.RRRRRRRR.RRRRRRRRRRRRRRRRRRRRRRRRRRRRRR"));
        assertEquals(2, RainyDay.minimumRainTime("Y.C.CCCCCCCCCCCCCCCCCCCCCC...C.CCCCCCCCCCCCCCH", ".RRRRRRRRRRRRRRR...RRR..R.R.R.R.R.R.R...R.R.RR"));
    }
}
