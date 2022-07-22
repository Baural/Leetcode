package leetcode.week1_22_07_2022;

import java.util.Arrays;

/**
 * @author baur
 * @date on 22.07.2022
 */


public class isAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sch = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            sch[i] = s.charAt(i);
        }
        Arrays.sort(sch);

        char[] tch = new char[t.length()];
        for (int i = 0; i < t.length(); i++) {
            tch[i] = t.charAt(i);
        }
        Arrays.sort(tch);

        for (int i = 0; i < s.length(); i++){
            if (sch[i] != tch[i])
                return false;
        }
        return true;
    }
}
