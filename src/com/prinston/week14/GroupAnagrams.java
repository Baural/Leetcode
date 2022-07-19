package com.prinston.week14;

import java.util.*;

/**
 * @author Baurzhan Alzhanov
 * @date on 20.05.2021
 */


public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(GroupAnagrams.groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        List<List<String>> anagrams = new ArrayList<>();
        for(List<String> l: map.values())
            anagrams.add(l);
        return anagrams;
    }
}
