package com.prinston.week34;

/**
 * @author Baurzhan Alzhanov
 * @date on 30.09.2021
 */


public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0){
            return true;
        }

        int l = 0;
        int r = s.length()-1;

        while (l < r){
            char c1 = s.charAt(l);
            char c2 = s.charAt(r);


            if (!Character.isLetterOrDigit(c1)) {
                l++;
            } else if (!Character.isLetterOrDigit(c2)) {
                r--;
            } else{
                if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) return false;
                l++;
                r--;
            }
        }
        return true;
    }




    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        String panama = "race a car";
        System.out.println(vp.isPalindrome(panama));
    }
}
