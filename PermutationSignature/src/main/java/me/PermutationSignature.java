package me;

public class PermutationSignature {

    public PermutationSignature() {}

    public static int[] reconstruct(String signature) {
        int[] re = new int[signature.length() + 1];
        re[0] = 1;
        for (int i = 0; i < signature.length(); i++) {
            re[i+1] = i+2;
            for (int j = i; j >= 0 && signature.charAt(j) == 'D'; j--) {
                int tmp = re[j];
                re[j] = re[j+1];
                re[j+1] = tmp;
            }
        }
        return re;
    }
}
