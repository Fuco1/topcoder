public class PrintMatrixDiag {

    public PrintMatrixDiag() {}

    public static void main(String[] args) {
        printMatrix(4,3);
    }

    public static void printMatrix(int w, int h) {
        for (int d = 0; d < w + h - 1; d++) {
            int mw = Math.min(w - 1, d);
            int mh = Math.min(h - 1, d);
            for (int i = mw; d - i <= mh; i--) {
                System.out.format("%3d %3d\n", d - i, i);
            }
        }
    }
}
