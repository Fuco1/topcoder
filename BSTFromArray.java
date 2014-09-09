import java.util.*;

public class BSTFromArray {

    public BSTFromArray() {}

    public static void main(String[] args) {
        System.out.println(bstsame(Arrays.<Integer>asList(new Integer[]{8,2,0,4,1,3,6,5,7,14,11,9,13,20,16,22}),
                                   Arrays.<Integer>asList(new Integer[]{8,14,20,22,16,11,13,9,2,4,6,7,5,3,0,1})));
        System.out.println(bstsame(Arrays.<Integer>asList(new Integer[]{1,2,3}),
                                   Arrays.<Integer>asList(new Integer[]{1,3,2})));
    }

    public static boolean bstsame(List<Integer> a1, List<Integer> a2) {
        if (a1.isEmpty() && a2.isEmpty()) return true;
        if (a1.get(0) != a2.get(0)) return false;
        List<Integer> a1l = new ArrayList<Integer>();
        List<Integer> a1r = new ArrayList<Integer>();
        List<Integer> a2l = new ArrayList<Integer>();
        List<Integer> a2r = new ArrayList<Integer>();
        for (int i : a1.subList(1,a1.size())) {
            if (i < a1.get(0)) a1l.add(i);
            else a1r.add(i);
        }
        for (int i : a2.subList(1,a2.size())) {
            if (i < a2.get(0)) a2l.add(i);
            else a2r.add(i);
        }
        return bstsame(a1l, a2l) && bstsame(a1r,a2r);
    }
}
