package liked;

import java.util.*;

public class Lc399 {
    class Node {
        String next;
        double value;

        public Node(String next, double value) {
            this.next = next;
            this.value = value;
        }
    }

    private HashMap<String, List<Node>> graph;

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        //build the map
        graph = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (graph.get(equation[0]) == null) {
                graph.put(equation[0], new ArrayList<>());
            }
            graph.get(equation[0]).add(new Node(equation[1], values[i]));
            if (graph.get(equation[1]) == null) {
                graph.put(equation[1], new ArrayList<>());
            }
            graph.get(equation[1]).add(new Node(equation[0], 1 / values[i]));
        }
        //dfs to get the result
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = find(queries[i][0], queries[i][1], 1, new HashSet<>());
        }
        return res;
    }

    private double find(String start, String end, double value, Set<String> visited) {
        if (visited.contains(start)) return -1;
        if (!graph.containsKey(start)) return -1;

        if (start.equals(end)) return value;
        visited.add(start);
        for (Node node : graph.get(start)) {
            double sub = find(node.next, end, value * node.value, visited);
            if (sub != -1.0) return sub;
        }
        visited.remove(start);
        return -1;

    }
}
