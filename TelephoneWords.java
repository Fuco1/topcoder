import java.util.*;

public class TelephoneWords {

    public TelephoneWords() {}

    public static void main(String[] args) {
        printCodes(new int[]{1,2,2,0,3});
    }

    private static boolean addOne(int[] data) {
        int carry = 1;
        for (int i = 0; i < data.length; i++) {
            data[i] = (data[i] + carry) % 3;
            carry = data[i] == 0 ? 1 : 0;
            if (carry == 0) return true;
        }
        return false;
    }

    private static char getNumChar(int num, int place) {
        if (num == 0) return '0';
        if (num == 1) return '1';
        return (char)('A' + (num - 2) * 3 + place);
    }

    public static void printCodes(int[] num) {
        boolean[] hasChars = new boolean[num.length];
        int numChars = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != 0 && num[i] != 1) {
                numChars++;
                hasChars[i] = true;
            }
        }

        int[] comb = new int[numChars];
        do {
            for (int i = 0, j = 0; i < num.length; i++) {
                if (hasChars[i]) {
                    System.out.print(getNumChar(num[i], comb[j++]));
                } else {
                    System.out.print(num[i]);
                }
            }
            System.out.println("");
        } while (addOne(comb));
    }
}
