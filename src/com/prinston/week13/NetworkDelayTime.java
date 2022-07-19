package com.prinston.week13;

import java.util.Arrays;

/**
 * @author Baurzhan Alzhanov
 * @date on 14.05.2021
 */


public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int [] dist = new int [n + 1];
        int maximum = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        for (int i=1; i<n; i++) {
            for (int [] edges : times) {
                int current = edges[0];
                int next = edges[1];
                int weight = edges[2];
                int distance = dist[current] + weight;
                if (dist[current] != Integer.MAX_VALUE && dist[next] > distance)
                    dist[next] = distance;
            }
        }
        for (int i=1; i<=n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            maximum = Math.max(maximum, dist[i]);
        }
        return maximum;
    }
}
