package me;

public class PaperFold {

    public PaperFold() {}

    public static int numFolds(int[] paper, int[] box) {
        int folds = numFoldsr(paper[0], paper[1], box[0], box[1], 0);
        if (folds == 9) return -1;
        else return folds;
    }

    private static int min(int a, int b) {
        return a > b ? b : a;
    }

    private static int numFoldsr(double pw, double pl, double bw, double bl, int depth) {
        if (depth > 8) return 9;
        if ((pw <= bw && pl <= bl) ||
            (pl <= bw && pw <= bl)) {
            return depth;
        }
        return min(numFoldsr(pw / 2.0, pl, bw, bl, depth+1),
                   numFoldsr(pw, pl / 2.0, bw, bl, depth+1));
    }
}
