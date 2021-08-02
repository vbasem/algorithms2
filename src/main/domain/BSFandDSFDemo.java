package main.domain;

import java.util.*;

public class BSFandDSFDemo {

  HashMap<Integer, HashSet<Integer>> vertices = new HashMap<>();

  public static void main(String[] args) {
    BSFandDSFDemo bsFandDSFDemo = new BSFandDSFDemo();

    bsFandDSFDemo.add(1);
    bsFandDSFDemo.add(2);
    bsFandDSFDemo.add(3);
    bsFandDSFDemo.add(4);
    bsFandDSFDemo.add(5);

    bsFandDSFDemo.edge(1, 2);
    bsFandDSFDemo.edge(2, 4);
    bsFandDSFDemo.edge(2, 5);
    bsFandDSFDemo.edge(1, 3);
    bsFandDSFDemo.edge(1, 5);
    bsFandDSFDemo.bsf(1);
    //        bsFandDSFDemo.dfs();

  }

  private void bsf(int root) {
    LinkedList<Integer> queue = new LinkedList<>();
    HashSet<Object> visited = new HashSet<>();
    queue.add(root);
    boolean hasMore = true;
    while (queue.size() >0 ) {
      int currentElement = queue.poll();
      System.out.println("current element: " + currentElement);
      visited.add(currentElement);
      for (Integer child : vertices.get(currentElement)) {
        if (!visited.contains(child)) {
          queue.add(child);
        }
      }
    }
  }

  private void edge(int a, int b) {
    this.vertices.get(a).add(b);
  }

  private void add(int aNode) {
    this.vertices.put(aNode, new HashSet<>());
  }
}

