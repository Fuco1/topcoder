package me;
import java.util.*;
import java.io.*;
import java.math.*;

public class PerforatedSheet {

    public PerforatedSheet() {}

    public static double[] getCenterOfMass(int sheetWidth, int sheetHeight, int[] x, int[] y, int[] width, int[] height) {
        BigDecimal sw = new BigDecimal(sheetWidth);
        BigDecimal sh = new BigDecimal(sheetHeight);
        BigDecimal density = new BigDecimal(1);
        BigDecimal totalMass = sw.multiply(sh).multiply(density);
        BigDecimal two = new BigDecimal(2);
        BigDecimal cx = sw.divide(two).multiply(totalMass);
        BigDecimal cy = sh.divide(two).multiply(totalMass);
        //System.out.format("Total mass %.10f cx %.10f cy %.10f\n", totalMass, cx, cy);
        for (int i = 0; i < x.length; i++) {
            BigDecimal w = new BigDecimal(width[i]);
            BigDecimal h = new BigDecimal(height[i]);
            BigDecimal cmass = w.multiply(h).multiply(density);
            totalMass = totalMass.subtract(cmass);
            //System.out.format("cmass %.10f totalMass %.10f\n", cmass, totalMass);
            cx = cx.subtract(new BigDecimal(x[i]).add(w.divide(two, new MathContext(1000))).multiply(cmass));
            cy = cy.subtract(new BigDecimal(y[i]).add(h.divide(two, new MathContext(1000))).multiply(cmass));
        }
        //System.out.format("Total mass %.20f cx %.20f cy %.20f\n", totalMass, cx, cy);
        if (totalMass.compareTo(new BigDecimal(1/1e100)) < 0) {
            return new double[0];
        }
        cx = cx.divide(totalMass, new MathContext(1000));
        cy = cy.divide(totalMass, new MathContext(1000));
        if (cx.compareTo(new BigDecimal(1/1e9)) < 0 && cy.compareTo(new BigDecimal(1/1e9)) < 0) {
            return new double[0];
        }
        return new double[]{cx.doubleValue(),cy.doubleValue()};
    }
}
