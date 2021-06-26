package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author raychong
 */
public class RedundantConnection {
    Set<Integer> visitedConnection = new HashSet<>();

    // edges = [[1,2],[1,3],[2,3]]
    // [2,3]
    // 1 - 2, 3
    // 2 - 1, 3
    // 3 - 1, 2
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            visitedConnection.clear();
            if (graph.containsKey(edge[0]) && graph.containsKey(edge[1]) && dfs(graph, edge[0], edge[1])) {
                return edge;
            }
            List<Integer> connections = graph.getOrDefault(edge[0], new ArrayList<>());
            List<Integer> connections2 = graph.getOrDefault(edge[1], new ArrayList<>());
            connections.add(edge[1]);
            connections2.add(edge[0]);
            graph.put(edge[0], connections);
            graph.put(edge[1], connections2);
        }
        return new int[]{-1, -1};
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int source, int target) {
        if (visitedConnection.add(source)) {
            if (source == target) return true;
            for (int adjacent : graph.get(source)) {
                if (dfs(graph, adjacent, target)) return true;
            }
        }
        return false;
    }
}
