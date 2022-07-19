package com.prinston.week13;

/**
 * @author Baurzhan Alzhanov
 * @date on 14.05.2021
 */


import java.util.*; // For HashMap

public final class BellmanFord {
    /**
     * Given a directed, weighted graph G and a source node s, produces the
     * distances from s to each other node in the graph.  If any nodes in
     * the graph are unreachable from s, they will be reported at infinite
     * distance.
     *
     * @param graph The graph upon which to run Dijkstra's algorithm.
     * @param source The source node in the graph.
     * @return A map from nodes in the graph to their distances from the source.
     */
    public static <T> Map<T, Double> shortestPaths(DirectedGraph<T> graph, T source) {
        /* Construct a map from the nodes to their distances, then populate it
         * with the initial value of the recurrence (the source is at distance
         * zero from itself; all other nodes are at infinite distance).
         */
        Map<T, Double> result = new HashMap<T, Double>();
        for (T node: graph)
            result.put(node, Double.POSITIVE_INFINITY);
        result.put(source, 0.0);

        /* Create a new map that acts as scratch space.  We'll flip back and
         * forth between the result map and this map during each iteration of
         * the algortihm so that we avoid needlessly reallocating maps.
         */
        Map<T, Double> scratch = new HashMap<T, Double>();

        /* Starting with k = 1, compute the new values for the distances by
         * evaluating the recurrence.
         */
        for (int k = 1; k <= graph.size(); ++k) {
            /* Begin by guessing that each node in this new iteration will have
             * a cost equal to its cost on the previous iteration.
             */
            scratch.putAll(result);

            /* Scan across all the edges in the graph, updating the costs of
             * the paths of the nodes at their endpoints.
             */
            for (T node: graph) {
                for (Map.Entry<T, Double> edge: graph.edgesFrom(node).entrySet()) {
                    /* The new cost of the shortest path to this node is no
                     * greater than the cost of the shortest path to the nodes'
                     * neighbor plus the cost of the edge from that neighbor
                     * into this node.
                     */
                    scratch.put(edge.getKey(), // The node being updated
                            Math.min(scratch.get(edge.getKey()),
                                    edge.getValue() + result.get(node)));
                }
            }

            /* Finally, exchange the scratch buffer holding the new result with
             * the result map holding last iteration's results.
             */
            Map<T, Double> temp = result;
            result = scratch;
            scratch = temp;
        }

        /* Finally, report the distances. */
        return result;
    }
}