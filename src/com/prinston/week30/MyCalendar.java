package com.prinston.week30;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Baurzhan Alzhanov
 * @date on 07.09.2021
 */


public class MyCalendar {
    TreeMap<Integer, Integer> calendar;
    public MyCalendar() {
        calendar = new TreeMap<Integer, Integer>();
    }

    public boolean book(int start, int end) {
        Integer previous = calendar.floorKey(start);
        Integer next =calendar.ceilingKey(end);

        if((previous == null || calendar.get(previous) <= start) && (next == null || end < next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        MyCalendar newCalendar = new MyCalendar();
        System.out.println(newCalendar.book(47, 50));
        System.out.println( newCalendar.book(33, 41));
        System.out.println( newCalendar.book(39, 45));
        System.out.println( newCalendar.book(33, 42));
        System.out.println(newCalendar.book(25, 32));
        System.out.println(newCalendar.book(26, 35));
        System.out.println(newCalendar.book(19, 25));
    }
}


