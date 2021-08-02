package main.top;

import org.apache.commons.math3.analysis.function.Max;

public class MaxTreeBinary {

  public static void main(String[] args) {
    MaxTreeBinary maxTreeBinary = new MaxTreeBinary();
    System.out.println(
        "maxTreeBinary = "
            + maxTreeBinary.findMaxDepth(new Integer[] {1, 2, 3, 4, 5, 6, 6, 6, 6, 6}));

    TreeNode treeNode = new TreeNode(3);
    treeNode.left = new TreeNode(9);
    treeNode.right = new TreeNode(20);
    treeNode.right.left = new TreeNode(15);
    treeNode.right.right = new TreeNode(7);
    System.out.println("treeNode = " + treeNode.maxDepth());
  }


  public int findMaxDepth(Integer[] tree) {

    return max(tree, 0);
  }

  protected int max(Integer[] tree, int current) {

    if (current >= tree.length || tree[current] == null) {
      return 0;
    }

    return 1 + Math.max(max(tree, 2 * current + 1), max(tree, 2 * current + 2));
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    public int maxDepth() {
      if (left == null && right == null) {
        return 1;
      } else {
        return 1+ Math.max(left != null? left.maxDepth() : 0, right != null? right.maxDepth() : 0);
      }
    }



    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
