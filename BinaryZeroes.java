import java.util.*;

public class BinaryZeroes {

    public BinaryZeroes() {}

    public static void main(String[] args) {
        // binary("16");
        // binary("8");
        // binary("7");
        // binary("1248456");
        // binary("124843894574369242857348623492345345394583969234920673467395656");
        System.out.println(binary64(0b100010010));
        System.out.println(binary64(0b1));
    }

    // solution for int/long
    private static int binary64(long x) {
        long p;
        int cur;
        int last = 0;
        int max = 0;
        while (x > 0) {
            p = ~(x-1)&x;
            cur = 0;
            while ((p = p >>> 1) > 0) cur++;
            max = Math.max(cur - last - 1, max);
            last = cur;
            x -= (1 << cur);
        }
        return max;
    }

    // general solution
    private static void binary(String num) {
        int[] number = toNumber(num);
        while (true) {
            int i = 0;
            for (; i < number.length; i++) {
                if (number[i] != 0) break;
            }
            if (i == number.length) break;
            System.out.print(number[number.length-1] % 2);
            halve(number);
        }
        System.out.println("");
    }

    private static int[] toNumber(String num) {
        char[] tmp = num.toCharArray();
        int[] re = new int[tmp.length];
        for (int i = 0; i < re.length; i++) {
            re[i] = tmp[i] - '0';
        }
        return re;
    }

    private static int[] halve(int[] number) {
        int carry = 0;
        int i = 0;
        for (; i < number.length; i++) {
            if (number[i] != 0) break;
        }
        for (; i < number.length; i++) {
            int newcarry = number[i] % 2;
            number[i] = (number[i] / 2) + 5 * carry;
            carry = newcarry;
        }
        return number;
    }
}
