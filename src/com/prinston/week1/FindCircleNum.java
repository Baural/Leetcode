package com.prinston.week1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Baurzhan Alzhanov
 * @date on 25.02.2021
 */


public class FindCircleNum {
    public static void main(String[] args) {

        int[][] isConnected = {{1,1,0}, {1,1,0},{0,0,1}};
//        System.out.println(FindCircleNum.findCircleNum(isConnected));
    }


    class UnionFind{
        int[] f;
        public UnionFind(int size){
            f = new int[size];
            for(int i = 0; i < size; i++){
                f[i] = i;
            }
        }
        public int find(int x){
            if (f[x] != x){
                f[x] = find(f[x]);
            }
            return f[x];
        }
        public void unite(int x, int y){
            int fx = find(x);
            int fy = find(y);
            f[f[y]] = fx;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        if (isConnected.length == 0 || isConnected[0].length == 0) return 0;
        int row = isConnected.length, column = isConnected[0].length;
        UnionFind uf = new UnionFind(row);
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < row; i++){
            for(int j = i + 1; j < column; j ++){
                if (isConnected[i][j] == 1){
                    uf.unite(i,j);
                }
            }
        }
        for(int i=0; i<row; i++){
            uf.f[i] = uf.find(i);
            set.add(uf.f[i]);
        }
        return set.size();
    }
}
