import java.util.ArrayList;
import java.util.List;

/**
 * @author raychong
 */
public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        backtrack(paths, new ArrayList<>(), graph, 0);
        return paths;
    }

    private void backtrack(List<List<Integer>> paths, List<Integer> path, int[][] graph, int step) {
        List<Integer> newPath = new ArrayList<>(path);
        if (graph[step].length == 0 && step == graph.length - 1) newPath.add(step);
        if (graph[step].length == 0 && newPath.get(newPath.size() - 1) == graph.length - 1) {
            paths.add(newPath);
        }
        for (int j = 0; j < graph[step].length; j++) {
            newPath.add(step);
            backtrack(paths, newPath, graph, graph[step][j]);
            newPath.remove(newPath.size() - 1);
        }
    }
}
