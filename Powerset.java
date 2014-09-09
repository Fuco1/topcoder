import java.util.*;
import java.io.*;

public class Powerset {

    public Powerset() {}

    public static void main(String[] args) {
        System.out.println(powerset(Arrays.asList(1,2,3)));
    }

    private static List<List<Integer>> powerset(List<Integer> s) {
        if (s.isEmpty()) {
            List<Integer> empty = new ArrayList<Integer>();
            List<List<Integer>> re = new ArrayList<List<Integer>>();
            re.add(empty);
            return re;
        }
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        List<List<Integer>> sets = powerset(s.subList(1, s.size()));
        for (List<Integer> l : sets) {
            List<Integer> with = new ArrayList<Integer>(l);
            with.add(s.get(0));
            re.add(l);
            re.add(with);
        }
        return re;
    }
}
