// from topcoder
import java.util.*;

public class PerforatedSheet
{
    public double[] getCenterOfMass(int sheetWidth, int sheetHeight, int[] x, int[] y, int[] width, int[] height)
    {
        long mass = (long)sheetWidth * (long)sheetHeight;
        long sumX = (long)mass * (long)sheetWidth;
        long sumY = (long)mass * (long)sheetHeight;
        for (int i=0; i < x.length; i++)
        {
            long m = (long)width[i] * (long)height[i];
            mass -= m;
            sumX -= m * (2 *(long)x[i] + (long)width[i]);
            sumY -= m * (2 *(long)y[i] + (long)height[i]);
        }
        if (mass == 0) return new double[]{};
        return new double[] { 0.5 * sumX / (double)mass, 0.5 * sumY / (double)mass};
    }

}
