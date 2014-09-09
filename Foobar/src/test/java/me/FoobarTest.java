package me;

import org.junit.*;
import static org.junit.Assert.*;

public class FoobarTest {

    public FoobarTest() {}

    @Test
    public void test() throws Exception {
        assertEquals("I say ***** on this **** problem and the **** set!", Foobar.censor("ogg", "08B", "I say f00ey on this dan8 problem and the danB set!"));
        assertEquals("What the ******* is this *********?", Foobar.censor("eafk", "88$$", "What the h 8 c $ is this s n 8 $ u?"));
        assertEquals("Dung? What the ding do you mean, ****?", Foobar.censor("au", "ui", "Dung? What the ding do you mean, dung?"));
        assertEquals("****itALLto****", Foobar.censor("YYYggggabcdefghijklmnopqrstuvwxyz", "XXXggggABCDEFGHIJKLMNOPQRSTUVWXYZ", "DANGitALLtoHECK"));
        assertEquals("***********, I say, *********************.", Foobar.censor("ddhhooggss<y}T?h:1+Wd~\\'\"", "D*HNO0G&S5Rfubar%f3k<:...", "Dangoshucks, I say, * a n & 0 5 H u c k 5."));
    }
}
