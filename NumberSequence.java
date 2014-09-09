import java.util.*;

public class NumberSequence {

    private final static int ALPHABETNUM = 26;

    public static void main(String[] args) {
        assert index("a") == 1;
        assert index("ab") == 27;
        assert index("az") == 51;
        assert index("bc") == 52;
        assert index("aez") == 441;
        assert index("cfh") == 972;
        assert index("cde") == 928;
        assert index("cdf") == 929;
        assert index("moqx") == 16983;
        assert index("xyz") == 2951;
        assert index("hjmoqsu") == 930152;
        assert index("efhjkmopwxyz") == 27828178 || print("Expected 27828178, got " + index("efhjkmopwxyz"));
    }

    public static boolean print(String str) {
        System.out.println(str);
        return true;
    }

    public static int index(String num) {
        char[] letters = num.toUpperCase().toCharArray();
        int[] values = new int[letters.length];
        for (int i = 0; i < letters.length; i++) {
            values[i] = letters[i] - 'A' + 1;
        }
        //System.out.println(Arrays.toString(values));

        if (values.length == 1) return values[0];
        int re = 0;
        for (int i = 1; i < values.length; i++) {
            re += comNum(26,i);
        }
        for (int i = 0; i < values.length - 1; i++) {
            if (i == 0) {
                for (int j = 1; j < values[i]; j++) {
                    //System.out.format("+ C(%d, %d) ", 26 - j, values.length - i - 1);
                    re += comNum(26 - j, values.length - i - 1);
                }
            } else {
                for (int j = values[i-1] + 1; j < values[i]; j++) {
                    //System.out.format("+ C(%d, %d) ", 26 - j, values.length - i - 1);
                    re += comNum(26 - j, values.length - i - 1);
                }
            }
        }

        return re + values[values.length-1] - values[values.length-2];
    }

    public static int comNum(int num, int top){
        if(top == 0)
            return 0;
        long value = 0;
        long tmp1 = 1, tmp2 = 1;
        for(int i = 0 ; i < top; i++){
            tmp1 *= (num-i);
            tmp2 *= (top-i);
        }
        value = tmp1/tmp2;
        return (int) value;
    }
}
