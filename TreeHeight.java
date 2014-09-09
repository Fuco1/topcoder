import java.util.*;

public class TreeHeight {

    public TreeHeight() {}

    public static void main(String[] args) {
        System.out.println(depth(new int[]{3,3,3,-1,2}));
        System.out.println(depth(new int[]{4,8,3,8,5,8,3,4,-1,1,9,10,9}));
    }

    public static int depth(int[] parents) {
        int[] heights = new int[parents.length];
        for (int i = 0; i < parents.length; i++) {
            if (heights[i] == 0) {
                doDepth(parents, i, heights);
            }
        }
        int max = 0;
        for (int i : heights) {
            if (i > max) max = i;
        }
        return max;
    }

    public static int doDepth(int[] parents, int i, int[] heights) {
        if (parents[i] == -1) {
            return 0;
        }
        if (heights[i] == 0) {
            heights[i] = 1 + doDepth(parents, parents[i], heights);
            return heights[i];
        }
        return heights[i];
    }
}
