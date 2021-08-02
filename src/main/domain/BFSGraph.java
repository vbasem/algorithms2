package main.domain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BFSGraph {

    public static void main(String[] args) {
        HashMap<Character, char[]> graph = new HashMap<>();
        graph.put('a', new char[]{'b','c'});
        graph.put('b', new char[]{'c'});
        graph.put('c', new char[]{'e','f'});
//        graph.put('e', new char[]{'d'});
        graph.put('f', new char[]{'g'});
        graph.put('g', new char[]{'h'});
        graph.put('h', new char[]{'i'});
        graph.put('i', new char[]{'d'});
        System.out.println(new BFSGraph().findShortestPath(graph, 'a', 'd'));

    }

    public int findShortestPath(Map<Character, char[]> graph, char start, char finish) {
        LinkedList<Character> queue = new LinkedList<>();

        // get
        if (graph.get(start) == null) {
            return -1;
        }

        for (char item : graph.get(start)) {
            if (item == finish) {
                return 1;
            }
            queue.add(item);
        }

        return  1+ traverse(graph, queue, finish);
    }

    protected int traverse(Map<Character, char[]> graph, LinkedList<Character> queue, char finish) {
        LinkedList<Character> nextLevelQueue = new LinkedList<>();

        while (queue.size() > 0) {
            Character start = queue.removeFirst();
            if (graph.containsKey(start)) {
                for (char item : graph.get(start)) {
                    if (item == finish) {
                        return  1;
                    }
                    nextLevelQueue.add(item);
                }
            }
        }

        if (nextLevelQueue.size() > 0) {
            return 1+ traverse(graph, nextLevelQueue, finish);
        } else {
            return -1;
        }
    }
}
