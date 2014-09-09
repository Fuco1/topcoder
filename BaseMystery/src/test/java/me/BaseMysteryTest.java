package me;

import org.junit.*;
import static org.junit.Assert.*;

public class BaseMysteryTest {

    public BaseMysteryTest() {}

    @Test
    public void getBaseTest() throws Exception {
        assertArrayEquals(new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, BaseMystery.getBase("1+1=2"));
        assertArrayEquals(new int[]{2}, BaseMystery.getBase("1+1=10"));
        assertArrayEquals(new int[]{}, BaseMystery.getBase("1+1=3"));
        assertArrayEquals(new int[]{14}, BaseMystery.getBase("ABCD+211=B000"));
        assertArrayEquals(new int[]{15}, BaseMystery.getBase("ABCD+322=B000"));
        assertArrayEquals(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, BaseMystery.getBase("1+0=1"));
        assertArrayEquals(new int[]{20}, BaseMystery.getBase("GHIJ+1111=HJ00"));
        assertArrayEquals(new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, BaseMystery.getBase("1234+8765=9999"));
        assertArrayEquals(new int[]{10}, BaseMystery.getBase("1234+8766=10000"));
        assertArrayEquals(new int[]{20}, BaseMystery.getBase("JJJJ+JJJJ=1JJJI"));
        assertArrayEquals(new int[]{20}, BaseMystery.getBase("A9A9A+9A9A9=JJJJJ"));
        assertArrayEquals(new int[]{19}, BaseMystery.getBase("I63+81G=1780"));
        assertArrayEquals(new int[]{}, BaseMystery.getBase("28H77+E8=7D37C"));
        assertArrayEquals(new int[]{20}, BaseMystery.getBase("E8+CDJE=CEE2"));
        assertArrayEquals(new int[]{20}, BaseMystery.getBase("9+4FAIH=4FAJ6"));
        assertArrayEquals(new int[]{20}, BaseMystery.getBase("F4+AH1=BC5"));
        assertArrayEquals(new int[]{}, BaseMystery.getBase("JB+11H9=F9F"));
        assertArrayEquals(new int[]{19}, BaseMystery.getBase("4CCF+4=4CD0"));
        assertArrayEquals(new int[]{19, 20}, BaseMystery.getBase("6+I3=I9"));
        assertArrayEquals(new int[]{20}, BaseMystery.getBase("6F+I=7D"));
        assertArrayEquals(new int[]{11}, BaseMystery.getBase("8+A78=A85"));
        assertArrayEquals(new int[]{}, BaseMystery.getBase("JI+A14=EDGD"));
        assertArrayEquals(new int[]{19}, BaseMystery.getBase("26C+G20EA=G2323"));
        assertArrayEquals(new int[]{19}, BaseMystery.getBase("7B+I23E3=I242E"));
        assertArrayEquals(new int[]{19}, BaseMystery.getBase("I0HE+6=I0I1"));
        assertArrayEquals(new int[]{14, 15, 16, 17, 18, 19, 20}, BaseMystery.getBase("9+D82=D8B"));
        assertArrayEquals(new int[]{15, 16, 17, 18, 19, 20}, BaseMystery.getBase("5+5499=549E"));
        assertArrayEquals(new int[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, BaseMystery.getBase("3+1=4"));
        assertArrayEquals(new int[]{16}, BaseMystery.getBase("94529+58=94581"));
        assertArrayEquals(new int[]{}, BaseMystery.getBase("E+3D8=2J1A3"));
        assertArrayEquals(new int[]{20}, BaseMystery.getBase("BE+7FB=875"));
        assertArrayEquals(new int[]{}, BaseMystery.getBase("BI2B2+3I7DJ=2"));
        assertArrayEquals(new int[]{10}, BaseMystery.getBase("29+8=37"));
        assertArrayEquals(new int[]{20}, BaseMystery.getBase("FI+64B7=6575"));
        assertArrayEquals(new int[]{20}, BaseMystery.getBase("AJBD+3BF=B338"));
        assertArrayEquals(new int[]{}, BaseMystery.getBase("7H+JE6=71"));
        assertArrayEquals(new int[]{}, BaseMystery.getBase("J+B21=BF"));
        assertArrayEquals(new int[]{19}, BaseMystery.getBase("27829+B=27831"));
        assertArrayEquals(new int[]{19}, BaseMystery.getBase("1GGH+H36=2F14"));
        assertArrayEquals(new int[]{19}, BaseMystery.getBase("IE30+I9H8=1I518"));
        assertArrayEquals(new int[]{20}, BaseMystery.getBase("JH+I40=J3H"));
        assertArrayEquals(new int[]{19}, BaseMystery.getBase("H1FI+73FHA=81HE9"));
        assertArrayEquals(new int[]{18}, BaseMystery.getBase("ACC4+329C7=3D46B"));
        assertArrayEquals(new int[]{20}, BaseMystery.getBase("JHEGI+JF1=JIEBJ"));
        assertArrayEquals(new int[]{19}, BaseMystery.getBase("E+B21C=B227"));
        assertArrayEquals(new int[]{20}, BaseMystery.getBase("G04+CCHJ=D8I3"));
        assertArrayEquals(new int[]{}, BaseMystery.getBase("34G74+G=1027"));
        assertArrayEquals(new int[]{}, BaseMystery.getBase("9F+2BDA=2B2D"));
        assertArrayEquals(new int[]{16, 17, 18, 19, 20}, BaseMystery.getBase("C+603=60F"));
        assertArrayEquals(new int[]{20}, BaseMystery.getBase("E+H7AD=H7B7"));
        assertArrayEquals(new int[]{17}, BaseMystery.getBase("F248G+8AC=F2D2B"));
        assertArrayEquals(new int[]{17}, BaseMystery.getBase("C3+4F6D=4G1G"));
        assertArrayEquals(new int[]{17}, BaseMystery.getBase("G24+F=G32"));
        assertArrayEquals(new int[]{17}, BaseMystery.getBase("DFF+E6=ED4"));
        assertArrayEquals(new int[]{}, BaseMystery.getBase("2JB2+AF58H=17"));
        assertArrayEquals(new int[]{10}, BaseMystery.getBase("9+23=32"));
        assertArrayEquals(new int[]{20}, BaseMystery.getBase("B0+JAGF=JB7F"));
        assertArrayEquals(new int[]{19}, BaseMystery.getBase("873+1GICD=1H80G"));
        assertArrayEquals(new int[]{20}, BaseMystery.getBase("BFA2E+33C=BFD66"));
        assertArrayEquals(new int[]{15}, BaseMystery.getBase("D+AE=BC"));
        assertArrayEquals(new int[]{17}, BaseMystery.getBase("69+7F7=84G"));
        assertArrayEquals(new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, BaseMystery.getBase("1234+8765=9999"));
        assertArrayEquals(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, BaseMystery.getBase("0+0=0"));
        assertArrayEquals(new int[]{}, BaseMystery.getBase("1+A=0"));
        assertArrayEquals(new int[]{}, BaseMystery.getBase("1A+1=2"));
        assertArrayEquals(new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, BaseMystery.getBase("1+1=2"));
        assertArrayEquals(new int[]{11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, BaseMystery.getBase("A+0=A"));
        assertArrayEquals(new int[]{}, BaseMystery.getBase("9+3=2"));
        assertArrayEquals(new int[]{17, 18, 19, 20}, BaseMystery.getBase("FFFF+1=FFFG"));
        assertArrayEquals(new int[]{11}, BaseMystery.getBase("A+2=11"));
    }
}
