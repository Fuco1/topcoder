package me;
import java.util.*;
import java.io.*;

public class Aaagmnrs {

    public Aaagmnrs() {}

    public static String[] anagrams(String[] phrases) {
        Map<String, String> m = new LinkedHashMap<String, String>();
        for (String s : phrases) {
            char[] t = s.toLowerCase().replace(" ", "").toCharArray();
            Arrays.sort(t);
            String tt = String.valueOf(t);
            if (!m.containsKey(tt)) {
                m.put(tt, s);
            }
        }
        List<String> r = new ArrayList(m.values());
        return r.toArray(new String[0]);
    }
}
