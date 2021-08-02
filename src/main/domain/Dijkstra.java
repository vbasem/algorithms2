package main.domain;


import java.util.*;

// Directed Acyclic Graph
public class Dijkstra {

    public static void main(String[] args) {
        HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();
        graph.put("book", new HashMap<>());
        graph.put("poster", new HashMap<>());
        graph.put("lp", new HashMap<>());
        graph.put("drum", new HashMap<>());
        graph.put("guitar", new HashMap<>());
        graph.put("piano", new HashMap<>());

        graph.get("book").put("lp", 5);
        graph.get("book").put("poster", 0);
        graph.get("poster").put("drum", 35);
        graph.get("poster").put("guitar", 20);
        graph.get("lp").put("guitar", 15);
        graph.get("lp").put("drum", 20);
        graph.get("drum").put("piano", 10);
        graph.get("guitar").put("piano", 20);

        Integer solve = new Dijkstra().solve(graph, "book", "piano");
        System.out.println(solve);
    }

    private Integer solve(HashMap<String, HashMap<String, Integer>> graph, String start, String end) {
        HashMap<String, Boolean> visited = new HashMap<>();
        HashMap<String, Integer> costs = new HashMap<>();
        HashMap<String, String> parent = new HashMap<>();
        visited.put(start, true);
        costs.put(end, Integer.MAX_VALUE);
        for (String s : graph.get(start).keySet()) {
            parent.put(s, start);
            costs.put(s, graph.get(start).get(s));
        }

        String lowestCost = getLowestCost(costs, visited, end);

        while (lowestCost != null) {
            visited.put(lowestCost, true);
            System.out.println("lowest is " + lowestCost);
            HashMap<String, Integer> children = graph.get(lowestCost);

            for (String child : children.keySet()) {
                int newCost = costs.get(lowestCost) + children.get(child);
                if (costs.get(child) == null || costs.get(child) > newCost) {
                    costs.put(child, newCost);
                    parent.put(child, lowestCost);
                }
            }

            lowestCost = getLowestCost(costs, visited, end);
        }
        parent.forEach((s, s2) -> {
            System.out.printf("%s ->%s\n", s, s2);
        });
        return costs.get(end);
    }

    private String getLowestCost(HashMap<String, Integer> costs, HashMap<String, Boolean> visited, String end) {
        int smallest = Integer.MAX_VALUE;
        String node = null;
        for (String s : costs.keySet()) {
            if (!Objects.equals(s, end) && !visited.containsKey(s) && smallest > costs.get(s)) {
                smallest = costs.get(s);
                node = s;
            }
        }
        return node;
    }

}

