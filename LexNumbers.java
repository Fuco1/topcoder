public class LexNumbers {

    public LexNumbers() {}

    public static void main(String[] args) {
        int max = (args.length == 1) ? Integer.parseInt(args[0]) : 100;
        for (int i = 1; i < 10; i++) {
            gen("" + i, max);
        }
    }

    private static void gen(String num, int max) {
        if (Integer.parseInt(num) > max) return;
        System.out.println(num);
        for (int i = 0; i < 10; i++) {
            gen(num + i, max);
        }
    }
}
