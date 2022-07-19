package com.prinston.week22;

/**
 * @author Baurzhan Alzhanov
 * @date on 15.07.2021
 */


public class MultiStack {
    private class StackInfo {
        private int start, size, capacity;
        public StackInfo(int start, int capacity){
            this.start = start;
            this.capacity = capacity;
        }

        public boolean isWithinStackCapacity(int index){
            if(index < 0 || index >= values.length){
                return false;
            }
            int contiguousIndex = index < start ? index + values.length : index;
            int end = start + capacity;
            return start <= contiguousIndex && contiguousIndex < end;
        }

        public int lastElement;


    }

    private StackInfo[] info;
    private int[] values;
}
