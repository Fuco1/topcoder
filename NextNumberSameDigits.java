public class NextNumberSameDigits {

    public NextNumberSameDigits() {}

    public static void main(String[] args) {
        int num = 11122;
        for (int i = 0; i < 20; i++) {
            System.out.println(num);
            num = nextNumber(num);
        }

    }

    public static int nextNumber(int number) {
        char[] digits = Integer.toString(number).toCharArray();
        int k = digits.length - 2;
        int l = digits.length - 1;
        while (k >= 0 && digits[k] >= digits[k+1]) k--;
        if (k < 0) return number;
        while (digits[k] >= digits[l]) l--;
        char tmp = digits[k];
        digits[k] = digits[l];
        digits[l] = tmp;
        k++;
        l = digits.length - 1;
        while (k < l) {
            tmp = digits[k];
            digits[k] = digits[l];
            digits[l] = tmp;
            k++; l--;
        }
        return Integer.parseInt(new String(digits));
    }
}
