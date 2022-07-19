package com.prinston.week1;

/**
 * @author Baurzhan Alzhanov
 * @date on 25.02.2021
 */

public class RegionsBySlashes {
    public static void main(String[] args) {
        String[] grid = new String[]{"/\\", "\\/"};
        System.out.println(new RegionsBySlashes().regionsBySlashes(grid));
    }


    public static int regionsBySlashes(String[] grid) {

        int n = grid.length;

        int[] parents = new int[n * n * 4];
        int parent = 0;

        int col;
        char ch;
        for (int row = 0; row < n; row++) {
            col = 0;
            while (col < grid[row].length()) {
                ch = grid[row].charAt(col);
                if (ch == '/') {
                    parents[parent] = parent;
                    parents[parent + 1] = parent + 1;
                    parents[parent + 2] = parent + 1;
                    parents[parent + 3] = parent;
                } else if (ch == '\\') {
                    parents[parent] = parent;
                    parents[parent + 1] = parent;
                    parents[parent + 2] = parent + 2;
                    parents[parent + 3] = parent + 2;
                } else {
                    parents[parent] = parent;
                    parents[parent + 1] = parent;
                    parents[parent + 2] = parent;
                    parents[parent + 3] = parent;
                }
                parent += 4;

                if (col > 0) {
                    // union with left
                    union(parents, row * 4 * n + (col - 1) * 4 + 1, row * 4 * n + (col) * 4 + 3);
                }
                if (row > 0) {
                    // union with top
                    union(parents, row * 4 * n + col * 4, (row - 1) * 4 * n + (col) * 4 + 2);
                }

                col++;
            }

        }

        int counter = 0;
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == i)
                counter++;
        }

        return counter;
    }


    public static void union(int[] parents, int i, int j) {
        int root1 = root(parents, i);
        int root2 = root(parents, j);
        if (root1 == root2)
            return;
        // TODO to balance?
        parents[root1] = root2;
    }


    private static int root(int[] parents, int i) {
        while (i != parents[i])
            i = parents[i];
        return i;
    }

}