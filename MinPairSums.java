import java.util.*;

public class MinPairSums {

    public MinPairSums() {}

    int[] A;
    int[] B;

    public MinPairSums(int[] A, int[] B) {
        this.A = A;
        this.B = B;
    }

    public void printSums(int k) {
        Queue<Pair> q = new PriorityQueue<Pair>();
        q.add(new Pair(0,0));
        while (k > 0) {
            Pair c = q.poll();
            if (c.j + 1 < B.length){
                q.add(new Pair(c.i, c.j + 1));
            }
            if (c.j == 0 && c.i + 1 < A.length) {
                q.add(new Pair(c.i + 1,0));
            }
            System.out.println(A[c.i] + B[c.j]);
            k--;
        }
    }

    private class Pair implements Comparable<Pair> {
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int compareTo(Pair other) {
            return Integer.compare(A[i] + B[j], A[other.i] + B[other.j]);
        }
    }

    public static void main(String[] args) {
        new MinPairSums(new int[]{1,3,6,10}, new int[]{2,3,4,5}).printSums(16);
    }
}
