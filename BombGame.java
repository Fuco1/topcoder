import java.util.*;

public class BombGame {

    public BombGame() {}

    public static void main(String[] args) {
        System.out.println(search(new int[]{6,8,3}, new int[]{7,3,1}));
        System.out.println(search(new int[]{1,4,3}, new int[]{9,0,3}));
        System.out.println(search(new int[]{7,2,3,4,10,4,5,5,3,8}, new int[]{5,5,2,6,6,1,2,4,3,3}));
        System.out.println(search(new int[]{1,3,1,1,1,1}, new int[]{1,2,1,1,0,0}));
        System.out.println(search(new int[]{1,1,10,1}, new int[]{0,1,2,1}));
        System.out.println(search(new int[]{7,2,3,4,10,4,5,5,3,8,7,2,3,4,10,4,5,5,3,8,7,2,3,4,10,4,5,5,3,8},
                                  new int[]{5,5,2,6,6,1,2,4,3,3,5,5,2,6,6,1,2,4,3,3,5,5,2,6,6,1,2,4,3,3}));
    }

    public static int search(int[] values, int[] range) {
        BitSet bs = new BitSet(values.length);
        bs.flip(0, bs.size());
        return doSearch(values, range, bs, new HashMap<BitSet, Integer>());
    }

    public static int doSearch(int[] values, int[] range, BitSet available, Map<BitSet, Integer> memo) {
        int max = 0;
        int cur = 0;
        if (memo.containsKey(available)) {
            return memo.get(available);
        }
        for (int i = available.nextSetBit(0); i >= 0 && i < values.length; i = available.nextSetBit(i+1)) {
            cur = values[i];
            BitSet newAvailable = new BitSet(values.length);
            newAvailable.or(available);
            for (int j = 0; j <= Math.min(range[i], values.length); j++) {
                int l = values.length;
                newAvailable.clear((i+j) % l);
                newAvailable.clear((((i-j) % l) + l) % l);
            }
            int re = doSearch(values, range, newAvailable, memo);
            cur += re;
            max = Math.max(cur, max);
        }
        memo.put(available, max);
        return max;
    }

    private static void printBS(BitSet bs, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(bs.get(i) ? "1" : "0");
        }
        System.out.println("");
    }
}
