public class RemoveBAC {

    public RemoveBAC() {}

    public static void main(String[] args) {
        System.out.println(removeBAC("b"));
        System.out.println(removeBAC("ac"));
        System.out.println(removeBAC("react"));
        System.out.println(removeBAC("bac"));
        System.out.println(removeBAC("taac"));
        System.out.println(removeBAC("teab"));
    }

    public static String removeBAC(String str) {
        char[] chars = str.toCharArray();
        int tar = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'b') continue;
            if (chars[i] == 'a' && i+1 < chars.length && chars[i+1] == 'c') {
                i++;
                continue;
            }
            chars[tar] = chars[i];
            tar++;
        }
        return new String(chars, 0, tar);
    }
}
