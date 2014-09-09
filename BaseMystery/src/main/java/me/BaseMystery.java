package me;

import java.util.*;

public class BaseMystery {

    public BaseMystery() {}

    private static int horner(int[] numbers, int base) {
        int re = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= base) throw new UnsupportedOperationException("Such number cannot be encoded in given base");
            re = (re * base) + numbers[i];
        }
        return re;
    }

    private static int[] getDigits(String number) {
        int[] re = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if ('0' <= c && c <= '9') {
                re[i] = c - '0';
            } else {
                re[i] = 10 + c - 'A';
            }
        }
        return re;
    }

    public static int[] getBase(String equation) {
        String[] tokens = equation.split("\\+|=");
        int[] left = getDigits(tokens[0]);
        int[] right = getDigits(tokens[1]);
        int[] sum = getDigits(tokens[2]);

        List<Integer> bases = new ArrayList<Integer>();
        for (int i = 2; i <= 20; i++) {
            try {
                if (horner(left, i) + horner(right, i) == horner(sum, i)) {
                    bases.add(i);
                }
            } catch (Exception e) {
            }
        }

        int[] re = new int[bases.size()];
        for (int i = 0; i < re.length; i++) {
            re[i] = bases.get(i);
        }

        return re;
    }
}
