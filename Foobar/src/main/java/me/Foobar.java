package me;
import java.util.*;
import java.io.*;

public class Foobar {

    public Foobar() {}

    private static String[] badWords = {"heck", "gosh", "dang", "shucks", "fooey", "snafu", "fubar"};

    public static String censor(String plain, String code, String text) {
        boolean[] censor = new boolean[text.length()];
        Map<Character, Set<Character>> translate = new HashMap<Character, Set<Character>>();
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            char p = plain.charAt(i);
            if (!translate.containsKey(c)) {
                translate.put(c, new HashSet<Character>());
            }
            translate.get(c).add(p);
        }
        for (int i = 0; i < text.length(); i++) {
            wordloop:
            for (String word : badWords) {
                //System.out.format("Matching %s at %d\n", word, i);
                boolean found = true;
                int k = i;
                for (int j = 0; j < word.length() && k < text.length(); j++) {
                    if (!(text.charAt(k) == word.charAt(j) ||
                        (translate.containsKey(text.charAt(k)) &&
                         translate.get(text.charAt(k)).contains(word.charAt(j))))) {
                        found = false;
                        continue wordloop;
                    }
                    //System.out.format("Matched %c with %c\n", text.charAt(k), word.charAt(j));
                    k++;
                    if (j + 1 < word.length()) {
                        while (k < text.length() && text.charAt(k) == ' ') k++;
                        if (k >= text.length()) continue wordloop;
                    }
                }
                //System.out.format("Has match for %s at %d\n", word, i);
                if (found) {
                    for (int l = i; l < k; l++) {
                        censor[l] = true;
                    }
                }
            }
        }
        String re = "";
        for (int i = 0; i < text.length(); i++) {
            if (censor[i]) re += "*";
            else re+= text.charAt(i);
        }
        return re;
    }
}
