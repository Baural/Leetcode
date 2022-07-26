package com.prinston.week11;

import java.util.HashMap;

/**
 * @author Baurzhan Alzhanov
 * @date on 30.04.2021
 */


class Solution {
    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        int i = new Solution().strStr(haystack, needle);
        System.out.println(i);
    }
    public int strStr(String haystack, String needle)
    {   // Simplied Boyer-Moore Algorithm

        int n = haystack.length();
        int m = needle.length();
        if (m==0) return 0; // trivial search for empty string
        // uses character array to avoid the troublesome <String>.charAt(index) method
        char[] H = haystack.toCharArray();
        char[] N = needle.toCharArray();
        HashMap<Character,Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            lastIndex.put(H[i], -1); // initialize every characters with -1
        }
        for (int k = 0; k < m; k++)
        {
            lastIndex.put(N[k],k); // put index of last occurence
        }
        // start comparing haystack from position of last character in needle
        // we will scan backward from right to left
        int i = m - 1; // i is the scanning index in the haystack
        int k = m - 1; // k is the scanning index in the needle
        while (i < n) // when we haven't finished traversing the haystack
        {
            if (H[i] == N[k])
            {
                if (k == 0) return i; // if needle is found inside haystack, return the index
                // else, advance both indices backward to compare the previous letter
                i--;
                k--;
            }
            else // if character mismatch
            {
                i += m - Math.min(k, lastIndex.get(H[i]) + 1);
                /* character-jump heuristic
                 * let c = haystack.charAt(i), and c != needle.charAt(k), we will skip characters depending on if c exist in the needle or not
                 * if c is not in needle, we can shift i by m units (the length of the needle) past c without missing out any possible match
                 * if c is in the needle, we let j be the index of the c's last occurence in needle
                 * if j occurs before k, shift i by m - (j+1) to align the mismatched character c in haystack with the last occurence of c in needle
                 * if j occurs after k, just shift i by 1, effectively shifting the needle by 1 unit as well.
                 */
                k = m -1; // restart k
            }
        }
        return -1;

    }
}