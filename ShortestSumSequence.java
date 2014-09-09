public class ShortestSumSequence {

    public ShortestSumSequence() {}

    public static void main(String[] args) {
        seq(new int[]{2,1,1,4,3,6}, 8);
        seq(new int[]{4,-1,-1,4,2}, 6);
        seq(new int[]{-1,1}, 1);
        seq(new int[]{-5,-2,8,9,-2,-5}, 17);
        seq(new int[]{-5,-2,8,9,-2,-5,17}, 17);
    }

    public static void seq(int[] data, int target) {
        int l = 0;
        int h = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int minl = 0;
        int minh = 0;
        while (true) {
            if (sum < target) {
                if (l < h && data[l] < 0) {
                    sum -= data[l];
                    l++;
                } else {
                    if (h == data.length) break;
                    sum += data[h];
                    h++;
                }
            } else {
                if (l < h) {
                    sum -= data[l];
                    l++;
                }
            }
            if (sum >= target && h - l < min) {
                min = h - l;
                minl = l;
                minh = h;
            }
        }
        System.out.format("MinL: %3d MinH:%3d\n", minl, minh);
    }
}
