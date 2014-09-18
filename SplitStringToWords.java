import java.util.*;
import java.io.*;

public class SplitStringToWords {

    private static Set<String> d = new HashSet<String>();

    static {
        d.add("in"); d.add("general"); d.add("you'll"); d.add("probably"); d.add("want"); d.add("to"); d.add("learn"); d.add("about"); d.add("markov"); d.add("models"); d.add("and"); d.add("the"); d.add("viterbi"); d.add("algorithm"); d.add("the"); d.add("latter"); d.add("is"); d.add("a"); d.add("dynamic"); d.add("programming"); d.add("algorithm"); d.add("that"); d.add("may"); d.add("allow"); d.add("you"); d.add("to"); d.add("find"); d.add("plausible"); d.add("segmentations"); d.add("for"); d.add("a"); d.add("string"); d.add("without"); d.add("exhaustively"); d.add("testing"); d.add("every"); d.add("possible"); d.add("segmentation"); d.add("the"); d.add("essential"); d.add("insight"); d.add("here"); d.add("is"); d.add("that"); d.add("if"); d.add("you"); d.add("have"); d.add("n"); d.add("possible"); d.add("segmentations"); d.add("for"); d.add("the"); d.add("first"); d.add("characters"); d.add("and"); d.add("you"); d.add("only"); d.add("want"); d.add("to"); d.add("find"); d.add("the"); d.add("most"); d.add("likely"); d.add("segmentation"); d.add("you"); d.add("don't"); d.add("need"); d.add("to"); d.add("evaluate"); d.add("every"); d.add("one"); d.add("of"); d.add("these"); d.add("against"); d.add("subsequent"); d.add("characters"); d.add("you"); d.add("only"); d.add("need"); d.add("to"); d.add("continue"); d.add("evaluating"); d.add("the"); d.add("most"); d.add("likely"); d.add("one");
        d.add("segment");
        d.add("gmentu");
        d.add("blue");
        d.add("hotdog");
        d.add("hotdon");
        d.add("hot");
        d.add("dog");
        d.add("b");
        d.add("lue");
        d.add("done");
        d.add("ehotdonem");
        d.add("blu");
    }

    public SplitStringToWords() {}

    public static void main(String[] args) {
        split("inthesegment");
        split("bluehotdonem");
        split("bluehotdog");
    }

    public static void split(String s) {
        Set[] memo = new Set[s.length()+1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = new HashSet<Integer>();
        }
        boolean ok = doSplit(s, memo);
        int pos = s.length();
        Set<String> re = new HashSet<String>();
        print(s, memo, s.length(), re, "");
        System.out.println(re);
    }

    private static void print(String s, Set[] memo, int pos, Set<String> re, String partial) {
        if (memo[pos].isEmpty()) re.add(partial);
        for (Object f : memo[pos]) {
            int from = ((Integer)f).intValue();
            print(s, memo, from, re, s.substring(from, pos) + " " + partial);
        }
    }

    public static boolean doSplit(String s, Set[] memo) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                if ((i == 0 || !memo[i].isEmpty()) && d.contains(s.substring(i, j))) {
                    memo[j].add(i);
                }
            }
            while (i+1 < s.length() && memo[i+1].isEmpty()) i++;
        }
        return true;
    }
}
