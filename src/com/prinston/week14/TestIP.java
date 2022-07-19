package com.prinston.week14;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Baurzhan Alzhanov
 * @date on 21.05.2021
 */


public class TestIP {
    public static void main(String[] args) {
        TestIP tip = new TestIP();
        String s = "25525511135";
        System.out.println(tip.restoreIpAddresses(s));
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() < 4 || s.length() > 12){
            return result;
        }
        dfs(s, "", 0, result);
        return result;
    }

    private void dfs(String s, String sub, int index,  List<String> result){
        if (index == 4 || s.length() == 0){
            if(index == 4 && s.length() == 0){
                result.add(sub.substring(0, sub.length() -1));
            }
            return;
        }
        //            case: 1
        dfs(s.substring(1),sub + s.substring(0, 1)+ ".", index + 1, result);
        // case: 2
        if(s.length() > 1 && s.charAt(0) != '0'){
            dfs(s.substring(2),sub + s.substring(0, 2)+ ".", index + 1, result);
            // case: 3
            if(s.length() > 2 && Integer.valueOf(s.substring(0,3)) <= 255) {
                dfs(s.substring(3), sub + s.substring(0, 3) + ".", index + 1, result);
            }
        }
    }
}
