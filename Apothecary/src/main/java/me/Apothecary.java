package me;
import java.util.*;
import java.io.*;

public class Apothecary {

    public Apothecary() {}

    public static int[] balance(int w) {
        int l = (int)Math.ceil(Math.log(w)/Math.log(3)) + 1;
        boolean[] pos = new boolean[l];
        boolean[] neg = new boolean[l];
        int[] powers = new int[l];
        int c = 1;
        for (int i = 0; i < l; i++) {
            powers[i] = c;
            c *= 3;
        }
        int left = w;
        int right = 0;
        while (left != right) {
            l = powers.length - 1;
            while (powers[l] - Math.abs(left-right) > Math.abs(left-right)) l--;
            if (left > right) {
                pos[l] = true;
                right += powers[l];
            } else {
                neg[l] = true;
                left += powers[l];
            }
        }
        List<Integer> re = new ArrayList<Integer>();
        for (int i = 0; i < pos.length; i++) {
            if (pos[i]) re.add(powers[i]);
            if (neg[i]) re.add(-powers[i]);
        }
        Collections.sort(re);
        int[] arr = new int[re.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = re.get(i);
        }
        return arr;
    }
}
