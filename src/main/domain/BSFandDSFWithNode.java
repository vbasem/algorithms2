package main.domain;

import java.util.*;

public class BSFandDSFWithNode {

  public static void main(String[] args) {
    BSFandDSFWithNode d = new BSFandDSFWithNode();
    d.addNode(9);
    d.addNode(4);
    d.addNode(20);
    d.addNode(1);
    d.addNode(6);
    d.addNode(15);
    d.addNode(170);
    d.addEdge(9, 4);
    //    d.addEdge(1, );
    d.addEdge(9, 20);
    d.addEdge(4, 1);
    d.addEdge(4, 6);
    d.addEdge(20, 15);
    d.addEdge(20, 170);
    //    d.bsf(1, 4);
    d.dsfPreOrder();
    System.out.println();
    d.dsfInOrder();
  }

  private void dsfInOrder() {
    this.dsfInOrder(new Stack<ANode>(), this.data.get(9));
  }

  private void dsfPreOrder() {
    Stack<ANode> stack = new Stack<>();
    ANode aNode = this.data.get(9);
    stack.push(aNode);
    while (!stack.isEmpty()) {
      ANode next = stack.pop();
      System.out.print(next.value + " - ");
      for (int i = next.edges.size() - 1; i >= 0; i--) {
        stack.push(next.edges.get(i));
        //
      }
    }
  }

  private void dsfInOrder(Stack<ANode> stack, ANode node) {
    if (node.edges.size() > 0) {
      for (int i = node.edges.size() - 1; i >= 0; i--) {
        stack.push(node.edges.get(i));
      }
    }
    System.out.print(String.format("%d -", node.value));
  }

  private void bsf(int start, int destination) {
    this.data.get(start).bsf(destination, new HashSet<>());
  }

  HashMap<Integer, ANode> data = new HashMap<>();

  public void addNode(int n) {
    ANode aNode = new ANode(n);
    data.put(n, aNode);
  }

  public void addEdge(int a, int b) {
    ANode nodeA = this.data.get(a);
    ANode nodeB = this.data.get(b);
    nodeA.edges.add(nodeB);
  }
}

class ANode {
  int value;
  ArrayList<ANode> edges = new ArrayList<>();

  public ANode(int i) {
    this.value = i;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ANode aNode = (ANode) o;
    return value == aNode.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  public void bsf(int destination, HashSet<Integer> visited) {
    if (visited.contains(this.value)) {
      System.out.println(String.format("already visited %d", value));
      return;
    }

    visited.add(this.value);
    System.out.println(String.format("visting %d", value));
    if (this.value == destination) {
      System.out.println(String.format("found %d @ this node %d", destination, value));
    } else {
      for (ANode node : this.edges) {
        node.bsf(destination, visited);
      }
    }
  }
}
