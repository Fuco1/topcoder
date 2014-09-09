import java.util.*;

public class Combinations {

    public Combinations() {}

    public static void main(String[] args) throws InterruptedException {
        //printPerms(3);
        //recursiveCombs(6, 3);
        // boolean[] data = new boolean[5];
        // for (int i = 0; i < 32; i++) {
        //     for (boolean b : data) {
        //         if (b) System.out.print(1);
        //         else System.out.print(0);
        //     }
        //     System.out.println("");
        //     addOne(data);
        // }
        recursiveCombs2(5, 3, 0, new boolean[5]);
    }

    public static void recursiveCombs(int n, int k) {
        recursiveCombs1(n, k, new boolean[n]);
    }

    private static void printData(boolean[] data) {
        int i = 1;
        for (boolean b : data) {
            if (b) System.out.print(i + " ");
            i++;
        }
        System.out.println("");
    }

    public static void recursiveCombs1(int n, int k, boolean[] data) {
        if (k == 1) {
            for (int i = data.length - n; i < data.length; i++) {
                data[i] = true;
                printData(data);
                data[i] = false;
            }
        } else if (n == k) {
            for (int i = data.length - n; i < data.length; i++) {
                data[i] = true;
            }
            printData(data);
            for (int i = data.length - n; i < data.length; i++) {
                data[i] = false;
            }
        } else {
            data[data.length - n] = true;
            recursiveCombs1(n-1, k-1, data);
            data[data.length - n] = false;
            recursiveCombs1(n-1, k, data);
        }
    }

    public static void addOne(boolean[] data) {
        boolean carry = true;
        for (int i = 0; i < data.length; i++) {
            boolean newc = data[i] && carry;
            data[i] ^= carry;
            carry = newc;
        }
    }

    public static void recursiveCombs2(int n, int k, int index, boolean[] data) {
        if (k == 0) {
            printData(data);
        } else if (n == k) {
            for (int i = index; i < data.length; i++) {
                data[i] = true;
            }
            printData(data);
            for (int i = index; i < data.length; i++) {
                data[i] = false;
            }
        } else {
            data[data.length - n] = true;
            recursiveCombs2(n-1, k-1, index+1, data);
            data[data.length - n] = false;
            recursiveCombs2(n-1, k, index+1, data);
        }
    }
}
