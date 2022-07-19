package com.prinston.week13;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Baurzhan Alzhanov
 * @date on 11.05.2021
 */


public class BuddyStrings {
    public static void main(String[] args) {
        BuddyStrings bs = new BuddyStrings();
        System.out.println(bs.buddyStrings("ab", "ba"));
    }

//        public boolean buddyStrings(String a, String b) {
//            if (a.length() > b.length() && a.length() != b.length()) {
//                return false;
//            }
//            int n = a.length();
//            int i = -1;
//            int j = -1;
//            int count = 0;
//            int[] freq = new int[256];
//
////            Set<Character> aLetters = new HashSet<>();
//            for (int k = 0; k < n; k++) {
//                if (a.charAt(k) != b.charAt(k)) {
//                    count++;
//                    if (i == -1){
//                        i = k;
//                    } else if (j == -1) {
//                        j = k;
//                    } else {
//                    return false;
//                    }
//
////                    if (count > 2) {
////                        return false;
////                    }
//
//                    freq[a.charAt(k)]++;
//                }
//                if (count == 0) {
//                    for (int f : freq) {
//                        if (f > 1) return true;
//                    }
//                }
//                if (count != 2) {
//                    return false;
//                }
//            }
//            return a.charAt(i) == b.charAt(j) && a.charAt(j) == b.charAt(i);
//
//        }
//}

    public boolean buddyStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        int n = a.length();
        int i = -1;
        int j = -1;
        Set<Character> aLetters = new HashSet<>();
        for (int k = 0; k < n; k++) {
            if (a.charAt(k) != b.charAt(k)) {
                if (i == -1)
                    i = k;
                else if (j == -1)
                    j = k;
                else
                    return false;
            }
            aLetters.add(a.charAt(k));
        }
        if (i != -1 && j != -1)
            return a.charAt(i) == b.charAt(j) && a.charAt(j) == b.charAt(i);
        if (i != -1)
            return false;
        return aLetters.size() < a.length();
    }
}