package avl;

import java.util.Deque;
import java.util.LinkedList;

public class AvlTree {
  private Node root;

  public static void main(String[] args) {
    AvlTree tree = new AvlTree();
    tree.testAvl();
  }

  public void testAvl() {
    this.add(30);
    this.add(20);
    this.add(10);
    this.add(40);
    this.add(35);
    this.printTree();
  }

  public void add(int value) {}

  public void printTree() {
    Deque<Node> queue = new LinkedList<>();
    queue.add(this.root);

    while (queue.size() > 0) {
      Node current = queue.removeFirst();
      System.out.print(current.value + ",");
      current.bsf(queue);
    }
    System.out.println("\n------");
  }
}

class Node {
  int value;
  Node left;
  Node right;
  int height;

  public Node(int value) {
    this.value = value;
  }

  public void bsf(Deque queue) {
    if (left != null) {
      queue.add(this.left);
    }
    if (right != null) {
      queue.add(this.right);
    }
  }

  //    public Node add(Node node, Node parent) {
  //        Node result = this;
  //        if (node.value > this.value) {
  //            this.right = this.addRightChild(node, parent);
  //
  //            // if max height == 2
  //            // either rotate LR or RR
  //                // if new Node value < right child
  //                // we have an LR
  //                // else we have LL
  //            if (getMaxHeightOfChildren() == 2) {
  //                if (node.value < this.right.value) {
  //                    result = rightLeftTurn();
  //                } else {
  //                    result = leftTurn();
  //                }
  //            }
  //
  //        } else {
  //            this.left = this.addLeftChild(node, parent);
  //            if (getMaxHeightOfChildren() == 2) {
  //                if (node.value < this.left.value) {
  //                    result = leftRightTurn();
  //                } else {
  //                    result = rightTurn();
  //                }
  //            }
  //        }
  //
  //        updateHeight();
  //
  //        return result;
  //
  //    }

}
