public class MaxN {

    public MaxN() {}

    public static void main(String[] args) {
        assert 2 == maxN(new int[]{1,4,2,1});
        assert 3 == maxN(new int[]{900,2,901,3,1000});
        assert 5 == maxN(new int[]{10,10,10,10,10});
        assert 0 == maxN(new int[]{0,-1,-4,0});
        assert 2 == maxN(new int[]{1,4,2,3});
        assert 2 == maxN(new int[]{1,2,3,4});
    }

    public static int maxN(int[] data) {
        int[] counter = new int[data.length+1];
        for (int num : data) {
            num = Math.min(num, data.length);
            if (num > 0) {
                counter[num]++;
            }
        }
        int i = data.length;
        int n = counter[i];
        while (i > 0 && i > n) {
            n += counter[i-1];
            i--;
        }
        return i;
    }
}
