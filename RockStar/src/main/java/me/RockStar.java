package me;
import java.util.*;
import java.io.*;

public class RockStar {

    public RockStar() {}

    // kratsie riesenie v C
    // if(ff == 0 && fs == 0) return ss + (sf ? 1 : 0);
    // else if(fs == 0) return ff;
    // else if(sf < fs) return ff + ss + (sf+1) + sf;
    // else return ff + ss + fs + fs;

    public static int getNumSongs(int ff, int fs, int sf, int ss) {
        boolean fast = ff > 0 || fs > 0;
        int re = 0;
        if (fast) {
            re = ff;
            if (fs > 0) {
                re += 1 + ss;
                fs--;
                re += Math.min(sf, fs) * 2;
                if (sf - Math.min(fs,sf) > 0) re++;
            }
        } else {
            if (fs > 0 && sf > 0) {
                if (fs > sf) {
                    re += ff;
                    re += 1;
                    fs--;
                    re += ss;
                    re += Math.min(sf,fs) * 2;
                    if (sf - Math.min(fs,sf) > 0) re++;
                } else {
                    re += ss;
                    re += 1;
                    sf--;
                    re += ff;
                    re += Math.min(fs,sf) * 2;
                    if (fs - Math.min(fs,sf) > 0) re++;
                }
            }
            if (fs > 0) {
                re += ff;
                re += 1;
                fs--;
                re += ss;
                re += Math.min(sf,fs) * 2;
                if (sf - Math.min(fs,sf) > 0) re++;
            } else {
                re += ss;
                re += 1;
                sf--;
                re += ff;
                re += Math.min(sf,fs) * 2;
                if (fs - Math.min(fs,sf) > 0) re++;
            }
        }
        return re;
    }
}
