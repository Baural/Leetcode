package com.prinston.week10;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author Baurzhan Alzhanov
 * @date on 20.04.2021
 */

/*
 * Input: words = ["w","wo","wor","worl","world"]
 * Output: "world"
 * Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 */

class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    public TrieNode(){
        this.isEnd = false;
        this.children = new TrieNode[26];
    }
}
public class LongestWordInDictionary {

    public static void main(String[] args) {
        LongestWordInDictionary longestWordInDictionary = new LongestWordInDictionary();
        String res = longestWordInDictionary.longestWord(new String[]
                {"a", "banana", "app", "appl", "ap", "apply", "apple"});
        System.out.println(res);
    }


    TrieNode root = new TrieNode();

    public String longestWord(String[] words){
        if(words.length==0) return null;
        if(words.length==1) return words[0];

        String res = new String();
        Arrays.sort(words);

        for(String word: words){
            insert(word);
        }
        for(String word: words){
            if(word.length()==1){
                if(res.length()==0){
                    res=word;
                }
            } else {
                //Greater than current result
                if(word.length() > res.length()){
                    boolean check = false;
                    for (int d = 1; d < word.length(); d++) {
                        check = search(word.substring(0, d));
                        if(!check){
                            break;
                        }
                    }
                    if(check){
                        res = word;
                    }
                }
            }
        }
        return res;
    }

    public void insert(String word){
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if(cur.children[pos] == null){
                cur.children[pos] = new TrieNode();
            }
            cur = cur.children[pos];
        }
        cur.isEnd = true;
    }

    public boolean search(String word){
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if(cur.children[pos] != null){
                cur = cur.children[pos];
            } else {
                return false;
            }
        }
        return cur.isEnd;
    }
}
