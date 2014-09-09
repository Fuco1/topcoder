import com.google.common.collect.*;
import java.util.*;

public class Anagram {

    public Anagram() {}

    public static void main(String[] args) {
        System.out.println(isSubstring("abc", "abc"));
        System.out.println(isSubstring("abc", "bac"));
        System.out.println(isSubstring("abc", "bca"));
        System.out.println(isSubstring("abc", "fbagacucbay"));
        System.out.println(isSubstring("abc", "aaabc"));
        System.out.println(isSubstring("abc", "abbbcccab"));
        System.out.println(isSubstring("abc", "abbbcacab"));
        System.out.println(isSubstring("abc", "abbb"));
        System.out.println(isSubstring("abc", "abbbccaabb"));
        System.out.println(isSubstring("abc", "ababc"));
        System.out.println(isSubstring("aabc", "abababca"));
        System.out.println(isSubstring("abbc", "ababbbacb"));
        System.out.println(isSubstring("aabc", "abaabcd"));
    }

    public static boolean isSubstring(String needle, String string) {
        Multiset<Character> chars = HashMultiset.create();
        Deque<Character> cur = new ArrayDeque<Character>();
        for (char c : needle.toCharArray()) chars.add(c);
        for (char c : string.toCharArray()) {
            if (chars.contains(c)) {
                cur.add(c);
                chars.remove(c);
                if (chars.isEmpty()) {
                    return true;
                }
                // prvok by sa mal vzdy pridat, a z konca odoberat do prveho vyskytu VCETNE!... ab{c} pride b, co sa stane?
            } else if (!cur.isEmpty() && cur.peek() == c) {
                cur.poll();
                cur.add(c);
            } else {
                while (!cur.isEmpty() && cur.peek() != c) {
                    chars.add(cur.poll());
                }
            }
        }
        return false;
    }
}
