public class DecimalExpansion {

    public DecimalExpansion() {}

    public static void main(String[] args) {
        printDec(1,8);
        printDec(10,8);
        printDec(100,8);
        printDec(1,32);
        printDec(1,3);
        printDec(2,4);
        printDec(22,7);
        printDec(7,342);
        printDec(4,2);
        printDec(1,97);
    }

    public static int gcd(int a, int b) { return b==0 ? a : gcd(b, a%b); }

    public static void printDec(int n, int d) {
        int gcd = gcd(n,d);
        n = n / gcd;
        d = d / gcd;
        int t = 0;
        int tmp = d;
        while (tmp % 2 == 0) {
            tmp /= 2;
            t++;
        }
        int t5 = 0;
        while (tmp % 5 == 0) {
            tmp /= 5;
            t = Math.max(t, ++t5);
        }
        int period = 0;
        if (tmp != 1) {
            int r = 10 % tmp;
            while (r != 1) {
                r *= 10;
                r %= tmp;
                period++;
            }
        }
        System.out.print(n / d);
        System.out.print(".");
        int i = 0;
        do {
            if (i++ == t) {
                System.out.print("(");
            }
            n %= d;
            n *= 10;
            System.out.print(n / d);
        } while (t + --period >= 0);
        System.out.println(")");
    }
}
