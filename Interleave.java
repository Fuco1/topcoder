import java.util.*;

public class Interleave {

    public Interleave() {}

    public static void main(String[] args) {
        assert inter("", "", "");
        assert inter("abc", "", "abc");
        assert inter("", "abc", "abc");
        assert inter("ab", "cd", "abcd");
        assert inter("ab", "ac", "abac");
        assert inter("ab", "ac", "acab");
        assert inter("ab", "ac", "aacb");
        assert inter("ab", "ac", "aabc");
        assert inter("foo", "baz", "foobaz");
        assert inter("foo", "baz", "bazfoo");
        assert inter("foo", "baz", "fboaoz");
        assert inter("foo", "baz", "fobaoz");
        assert inter("foo", "baz", "fbazoo");
        assert inter("foo", "baz", "bfooaz");
        assert !inter("foo", "baz", "zaboof");
        assert inter("chocolate", "chips", "cchocohilaptes");
        assert !inter("chocolate", "chips", "chocochilatspe");
        assert inter("loremipsumdolorsitametconsectetuer", "adipiscingelitpraesentliberoorciauctorsed"
                     ,"loadreimippsumidsolocrsitamientgcelonitprsaecteetsueerntliberoorciauctorsed");
        assert inter("loremipsumdolorsitametconsectetuer", "adipiscingelitpraesentliberoorciauctorsed"
                     ,"ladoirpeimipssumcingelitpdorlaesoernstliitaberomeotrciaucctoronsecstetueedr");
        assert inter("loremipsumdolorsitametconsectetuer", "adipiscingelitpraesentliberoorciauctorsed"
                     ,"adlipiosrciengelmiitpspurmaesdeolontlirsibetramoeorctcoinsaeucctettuorersed");
        assert inter("loremipsumdolorsitametconsectetuer", "adipiscingelitpraesentliberoorciauctorsed"
                     ,"ladipoisrcingeemliitppsrumdolorsiaestaementlibteconrsoorecctietauuecrtorsed");
    }

    public static boolean inter(String a, String b, String c) {
        if (a.isEmpty() && b.isEmpty() && c.isEmpty()) return true;
        if (a.isEmpty() && b.equals(c)) return true;
        if (b.isEmpty() && a.equals(c)) return true;
        return (a.charAt(0) == c.charAt(0) && inter(a.substring(1), b, c.substring(1))) ||
            (b.charAt(0) == c.charAt(0) && inter(a, b.substring(1), c.substring(1)));
    }
}

// (interleave "loremipsumdolorsitametconsectetuer" "adipiscingelitpraesentliberoorciauctorsed")

// (defun interleave (a b)
//   (let ((first (string-to-list a))
//         (second (string-to-list b))
//         (out))
//     (--dotimes (funcall (-on '+ 'length) a b)
//       (let ((r (random 2)))
//         (cond
//          ((or (not first) (= r 1))
//           (push (car second) out)
//           (!cdr second))
//          ((or (not second) (= r 0))
//           (push (car first) out)
//           (!cdr first)))))
//     (apply 'string (nreverse out))))
