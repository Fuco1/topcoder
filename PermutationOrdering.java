import java.util.*;

public class PermutationOrdering {

    public PermutationOrdering() {}

    public static void main(String[] args) {
        order(new int[]{1,0,2,3}, new int[]{0,2,1,3});
        order(new int[]{0,1,2,3}, new int[]{0,2,1,3});
        order(new int[]{0,1,2,3}, new int[]{0,3,1,2});
        order(new int[]{1,4,0,2,3}, new int[]{4,1,0,3,2});
        order(new int[]{0,4,2,3,1}, new int[]{1,3,4,0,2});
    }

    public static void order(int[] p1, int[] p2) {
        Map<Integer, Integer> index1 = new HashMap<Integer, Integer>(p1.length);
        Map<Integer, Integer> cycles = new HashMap<Integer, Integer>(p1.length);
        for (int i = 0; i < p1.length; i++) {
            index1.put(p1[i],i);
        }
        for (int i = 0; i < p1.length; i++) {
            if (p1[i] != p2[i]) cycles.put(p1[i], p2[i]);
        }

        while (!cycles.isEmpty()) {
            boolean cycle = false;
            if (!cycles.containsKey(0)) {
                int start = cycles.keySet().iterator().next();
                cycles.put(0, start);
                cycle = true;
            }
            int source = 0;
            while (cycles.containsKey(source)) {
                int target = cycles.get(source);
                if (!cycles.containsKey(target) && cycle) {
                    target = 0;
                }
                System.out.println(index1.get(source) + " -> " + index1.get(target));
                cycles.remove(source);
                source = target;
            }
        }
        System.out.println("");
    }

    public static void swap(int[] data, int l, int h) {
        int tmp = data[l];
        data[l] = data[h];
        data[h] = tmp;
    }
}
