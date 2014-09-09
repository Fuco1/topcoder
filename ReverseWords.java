public class ReverseWords {

    public ReverseWords() {}

    public static void main(String[] args) {
        System.out.println("'A really long sentence.'");
        System.out.println('\'' + reverseWords("A really long sentence.") + '\'');
        System.out.println("'   A really long   sentence. '");
        System.out.println('\'' + reverseWords("   A really long   sentence. ") + '\'');

        System.out.println("'A really long sentence.'");
        System.out.println('\'' + reverseWordsRec("A really long sentence.") + '\'');
        System.out.println("'   A really long   sentence. '");
        System.out.println('\'' + reverseWordsRec("   A really long   sentence. ") + '\'');
    }

    public static String reverseWords(String s) {
        char[] str = s.toCharArray();
        char[] buf = new char[str.length];
        int spos = str.length - 1;
        int epos = str.length;
        int dpos = 0;

        while (spos >= 0) {
            if (str[spos] == ' ') {
                buf[dpos++] = ' ';
                epos = spos;
                spos--;
            } else if (spos - 1 < 0 || str[spos - 1] == ' ') {
                for (int i = spos; i < epos; i++) {
                    buf[dpos++] = str[i];
                }
                spos--;
            } else {
                spos--;
            }
        }
        return new String(buf);
    }

    public static void reverseString(char[] str, int from, int to) {
        for (int i = 0; i < (to - from) / 2; i++) {
            char tmp = str[from + i];
            str[from + i] = str[to - 1 - i];
            str[to - 1 - i] = tmp;
        }
    }

    public static String reverseWordsRec(String s) {
        char[] str = s.toCharArray();
        reverseString(str, 0, str.length);
        int wstart = 0;
        int wend = 0;
        while (wend < str.length) {
            if (str[wstart] == ' ') {
                wstart++;
                wend++;
            } else {
                wend++;
            }
            if (// wstart != wend &&
                (wend == str.length || str[wend] == ' ')) {
                reverseString(str, wstart, wend);
                wstart = wend;
            }
        }
        return new String(str);
    }
}
