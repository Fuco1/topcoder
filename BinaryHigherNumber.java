public class BinaryHigherNumber {

    public BinaryHigherNumber() {}

    public static void main(String[] args) {
        int x = 10;
        System.out.println(Integer.toString(x,2) + " " + Integer.toString(higher(x),2));
        x = 9;
        System.out.println(Integer.toString(x,2) + " " + Integer.toString(higher(x),2));
        x = 0b1011;
        System.out.println(Integer.toString(x,2) + " " + Integer.toString(higher(x),2));
        x = 0b1001111100;
        System.out.println(Integer.toString(x,2) + " " + Integer.toString(higher(x),2));
    }

    public static int higher(int x) {
        int p = ~(x-1)&x; // find first 1
        int q = p | (p << 1); // the 11 pattern
        while ((x & q) == q) { q <<= 1; }
        q &= (q-1);  // find first 01
        x ^= q;
        x ^= p;
        int zmask = ~(q-1);
        p = 0;
        q = x&(q-1);
        while (q != 0) {
            p <<= 1;
            p |= q&1;
            q >>= 1;
        }
        x &= zmask;
        x |= p;
        return x;
    }
}
