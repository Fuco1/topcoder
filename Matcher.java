import java.util.*;

public class Matcher {

    public Matcher() {}

    public static void main(String[] args) {
        assert match("a", "a");
        assert match("a*", "a");
        assert match("a*", "");
        assert match(".", "a");
        assert !match(".", "");
        assert match("ab*", "a");
        assert match("a.", "ab");
        assert match("a*a*a*", "aaa");
        assert match("a*a*a*", "aa");
        assert match("a*a*a*", "a");
        assert match("a*a*a*", "");
        assert match("a*a*a*b", "aaab");
        assert match("a*a*a*b", "aab");
        assert match("a*a*a*b", "ab");
        assert match("a*a*a*b", "b");
        assert match("a*a*a*.c", "bc");
        assert match("a*a*a*.c", "abc");
        assert match("a*a*a*.c", "aaabc");
        assert !match("a*a*a*.c", "aaaabc");
        assert match("b*.b*", "bab");
        assert match("b*.b*", "ab");
        assert match("b*.b*", "ba");
        assert !match("b.b*", "babc");
        assert match("a*.", "a");
        assert match("a*.", "b");
        assert match("a*.", "ab");
        assert match("a*.", "aa");
    }

    public static boolean match(String m, String s) {
        int p = 0;
        int i = 0;
        while (p < m.length()) {
            if (i < s.length() && m.charAt(p) == '.') { p++; i++; }
            else if (p+1 < m.length() && m.charAt(p+1) == '*') {
                // we need to try both possibilities, the RE is non-deterministic here
                return match(m.substring(p+2), s.substring(i)) ||
                    match(m.substring(p+2), s.substring(i+1));
            } else if (i < s.length() && m.charAt(p) == s.charAt(i)) {
                p++;
                i++;
            } else return false;
        }
        return i == s.length();
    }
}
