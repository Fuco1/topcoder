import java.util.*;

public class DecodeAlphabet {

    public DecodeAlphabet() {}

    public static void main(String[] args) {
        Map<String, Integer> memo = new HashMap<String, Integer>();
        int re = print("", "1123123439432123121231231231123131423123134123", memo);
        System.out.println(re);
    }

    public static int print(String prefix, String code, Map<String, Integer> memo) {
        if (code.isEmpty()) {
            //System.out.println(prefix);
            return 1;
        }
        if (memo.containsKey(code)) {
            return memo.get(code);
        }
        int a = 0;
        int b = 0;
        a = print(prefix + decode(code.substring(0,1)), code.substring(1), memo);
        if (code.length() >= 2) {
            String snd = code.substring(0,2);
            if (snd.compareTo("26") <= 0) {
                b = print(prefix + decode(snd), code.substring(2), memo);
            }
        }
        memo.put(code, a+b);
        return a + b;
    }

    private static char decode(String code) {
        return (char)(Integer.parseInt(code) - 1 + 'a');
    }
}
