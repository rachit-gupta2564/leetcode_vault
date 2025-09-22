// Last updated: 22/09/2025, 16:18:00
import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build the graph
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, val);
            graph.get(b).put(a, 1.0 / val);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), graph, new HashSet<>());
        }
        return result;
    }

    private double dfs(String start, String end, Map<String, Map<String, Double>> graph, Set<String> visited) {
        if (!graph.containsKey(start)) return -1.0;
        if (start.equals(end)) return 1.0;

        visited.add(start);
        Map<String, Double> neighbors = graph.get(start);
        for (String neighbor : neighbors.keySet()) {
            if (!visited.contains(neighbor)) {
                double d = dfs(neighbor, end, graph, visited);
                if (d != -1.0) {
                    return neighbors.get(neighbor) * d;
                }
            }
        }
        return -1.0;
    }
}
