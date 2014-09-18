import java.util.*;
import java.io.*;

public class GrayCode {

    public GrayCode() {}

    public static void main(String[] args) {
        print0(new int[4], 0);
    }

    public static void print0(int[] out, int pos) {
        if (pos >= out.length) {
            System.out.println(Arrays.toString(out));
            return;
        }
        out[pos] = 0;
        print0(out, pos+1);
        out[pos] = 1;
        print1(out, pos+1);
    }

    public static void print1(int[] out, int pos) {
        if (pos >= out.length) {
            System.out.println(Arrays.toString(out));
            return;
        }
        out[pos] = 1;
        print0(out, pos+1);
        out[pos] = 0;
        print1(out, pos+1);
    }
}
