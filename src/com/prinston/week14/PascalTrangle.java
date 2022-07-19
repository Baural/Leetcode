package com.prinston.week14;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Baurzhan Alzhanov
 * @date on 17.05.2021
 */


public class PascalTrangle {
    public static void main(String[] args) {
        List<List<Integer>> res = new PascalTrangle().generate(0);
        System.out.println(res.toString());

    }
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows ==0) {
            return triangle;
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> row =  new ArrayList<>();
            for (int j=0; j <= i; j++){
                if (j==0 || j==i){
                    row.add(1);
                } else {
                    row.add(triangle.get(i-1).get(j -1) + triangle.get(i-1).get(j));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
}
