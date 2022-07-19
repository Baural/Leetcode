package com.prinston.week15;

import java.util.*;

/**
 * @author Baurzhan Alzhanov
 * @date on 23.05.2021
 */


public class TopKFrequent {
    public static void main(String[] args) {
        TopKFrequent tp = new TopKFrequent();
        int b = 4;
        String[] mass = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(tp.topKFrequent(mass, b));
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String s : words){
            map.put(s, map.getOrDefault(s, 0) +1);
        }
        Queue<String> pq = new PriorityQueue<>((word1, word2) ->{
            int cmp = map.get(word2).compareTo(map.get(word1));
            if(cmp != 0) return cmp;
            return word1.compareTo(word2);
        });

        for (String word:  map.keySet()) {
            pq.add(word);
        }

        for (int i = 0; i < k; i++) {
            result.add(pq.poll());
        }

        return result;
    }
}
