package main.graph;

import java.util.HashMap;
import java.util.HashSet;

public class AdjacencyListGraph {

  HashMap<Integer, HashSet<Integer>> data = new HashMap<Integer, HashSet<Integer>>();

  public static void main(String[] args) {
    AdjacencyListGraph graph = new AdjacencyListGraph();
    graph.addVertex(1);
    graph.addVertex(2);
    graph.addVertex(3);
    graph.addVertex(4);
    graph.addVertex(5);
    graph.addVertex(6);


    graph.addEdge(1, 2);
    graph.addEdge(1, 3);
    graph.showConnections();
  }

  public void showConnections() {
    for(int num : data.keySet()) {
      System.out.printf("%d --> ", num);
      data.get(num).forEach(x -> System.out.printf(" %d", x));
      System.out.println();
    }
  }

  public void addVertex(int num) {
    if (!this.data.containsKey(num)) {
      this.data.put(num, new HashSet<Integer>());
    }
  }

  public void addEdge(int a, int b) {
    if (!this.data.containsKey(a) || !this.data.containsKey(b)) {
      return;
    }
    this.data.get(a).add(b);
    this.data.get(b).add(a);
  }
}
