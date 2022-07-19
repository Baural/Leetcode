package com.prinston.week32;

import java.util.Stack;

/**
 * @author Baurzhan Alzhanov
 * @date on 22.09.2021
 */


//public class MuQueue<T>{
//    Stack<T> stackNewst, stackOldest;
//    public MyQueue() {
//        stackNewst = new Stack<T>();
//        stackOldest = new Stack<T>();
//    }
//
//    public int size(){
//        return stackNewst.size() + stackOldest.size();
//    }
//
//    public void add(T value){
//        stackNewst.push(value);
//    }
//
//    private void shiftStacks() {
//        if(stackOldest.isEmpty()){
//            while (!stackNewst.isEmpty()){
//                stackOldest.push(stackNewst.pop());
//            }
//        }
//    }
//
//    public T peek() {
//        shiftStacks();
//        return stackOldest.peek();
//    }
//
//    public T remove() {
//        shiftStacks();
//        return stackOldest.pop();
//    }
//}
