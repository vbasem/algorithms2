package main.domain;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import org.jgrapht.ListenableGraph;
import org.jgrapht.demo.JGraphXAdapterDemo;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultListenableGraph;
import org.jgrapht.graph.SimpleDirectedGraph;

import javax.swing.*;
import java.awt.*;

public class BinaryTree<T extends Compareable> extends JApplet {
  TreeNode<T> root;
  private mxHierarchicalLayout layout;
  private JGraphXAdapter<Integer, DefaultEdge> jgxAdapter;
  private mxGraphComponent component;
  private ListenableGraph<Integer, DefaultEdge> g;

  public static void main(String[] args) throws InterruptedException {
    BinaryTree<MyNumber> tree = new BinaryTree<>(new MyNumber(10));
    tree.add(new MyNumber(7));
    tree.add(new MyNumber(6));
    tree.add(new MyNumber(5));
    tree.add(new MyNumber(12));
    tree.add(new MyNumber(3));
    tree.add(new MyNumber(14));
    tree.add(new MyNumber(25));
    tree.add(new MyNumber(55));
    tree.add(new MyNumber(11));
    tree.add(new MyNumber(8));
//    tree.remove(12);
//    tree.remove(7);

    tree.print();

    System.out.println(tree.lookup(8));
    System.out.println(tree.lookup(3));
    System.out.println(tree.lookup(12));

    tree.graphicGraph();

    JFrame frame = new JFrame();
    frame.getContentPane().add(tree);
    frame.setTitle("JGraphT Adapter to JGraphX Demo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);

    Thread.sleep(2000);
    tree.add(new MyNumber(17));
    tree.add(new MyNumber(19));
    tree.update();
    frame.invalidate();
    frame.validate();
    frame.repaint();

    Thread.sleep(2000);
    tree.remove(25);
    tree.update();
    frame.invalidate();
    frame.validate();
    frame.repaint();
  }

  private static void draw(BinaryTree<MyNumber> tree) {}

  public BinaryTree(T value) {
    this.root = new TreeNode<>(value);
  }

  public void add(T value) {
    this.root.add(value);
  }

  public TreeNode lookup(int v) {
    return this.root.lookup(v);
  }

  public void print() {
    root.print();
  }

  private void graphicGraph() {
    prepareGraphic();

    JGraphXAdapterDemo applet = new JGraphXAdapterDemo();
    applet.init();
  }

  private void prepareGraphic() {
    {
      // create a JGraphT graph
      g = new DefaultListenableGraph<>(new SimpleDirectedGraph<>(DefaultEdge.class));

      // create a visualization using JGraph, via an adapter
      jgxAdapter = new JGraphXAdapter<>(g);
      Dimension DEFAULT_SIZE = new Dimension(1060, 640);
      setPreferredSize(DEFAULT_SIZE);
      component = new mxGraphComponent(jgxAdapter);
      component.setConnectable(false);
      component.setAntiAlias(true);
      component.setCenterPage(true);
      component.getGraph().setAllowDanglingEdges(false);
      getContentPane().add(component);
      resize(DEFAULT_SIZE);

      addGraphData(g);

      // positioning via jgraphx layouts
      //      mxFastOrganicLayout layout = new mxFastOrganicLayout(jgxAdapter);
      layout = new mxHierarchicalLayout(jgxAdapter);
      // center the circle
      //      super(graph);
      //      this.roots = null;
      //      this.resizeParent = true;
      //      this.moveParent = false;
      //      this.parentBorder = 0;
      //      this.intraCellSpacing = 30.0D;
      //      this.interRankCellSpacing = 50.0D;
      //      this.interHierarchySpacing = 60.0D;
      //      this.parallelEdgeSpacing = 10.0D;
      //      this.orientation = 1;
      //      this.disableEdgeStyle = true;
      //      this.fineTuning = true;
      //      this.traverseAncestors = true;
      layout.setParallelEdgeSpacing(20.0D);
      layout.setMoveParent(true);
      layout.setDisableEdgeStyle(false);
      layout.setInterHierarchySpacing(100D);
      layout.setInterRankCellSpacing(100D);
      layout.setIntraCellSpacing(100D);
      layout.setResizeParent(true);
      layout.setUseBoundingBox(false);

      layout.execute(jgxAdapter.getDefaultParent());
      // that's all there is to it!...

    }
  }

  public void update() {
    addGraphData(g);
    layout.execute(jgxAdapter.getDefaultParent());
  }

  private void addGraphData(ListenableGraph<Integer, DefaultEdge> g) {
    this.root.printGraph(g);
  }

  public Integer delete(int val) {
    return ((MyNumber) this.root.delete(null, val).value).number;
  }

  public void remove(int val) {

    TreeNode currentNode = this.root;
    TreeNode parentNode = null;

    while (currentNode != null) {
      if (currentNode.value.isEqual(val)) {
        // start remove logic
        // is leaf -> just remove and cut parent connection off

        if (currentNode.left == null && currentNode.right == null) {
          removeLeaf(currentNode, parentNode);
          break;
        } else if (hasOnlyOneChild(currentNode)) {
          if (currentNode.left != null) {
            replaceSingleChildLeft(currentNode, parentNode);
            break;
          } else {
            replaceSingleChildRight(currentNode, parentNode);
            break;
          }
        } else {
          replaceDoubleChildren(currentNode, parentNode);
          break;
        }
        // has single child -> take child and attach to parent
        // has 2x children -> go right then
        // if doesnt have left node, replace found node with current node
        // attach left to found node
        // else
        // while get left most node

        // left of current becomes left of found node
        // parent of current gets the found node
        // left  of parent of found node , gets right children of found node

      } else if (currentNode.value.isSmaller(val)) {
        parentNode = currentNode;
        currentNode = currentNode.right;
      } else {
        parentNode = currentNode;
        currentNode = currentNode.left;
      }
    }
  }
  // has 2x children -> go right then
  // if doesnt have left node, replace found node with current node
  // attach left to found node
  // else
  // while get left most node

  // left of current becomes left of found node
  // parent of current gets the found node
  // left  of parent of found node , gets right children of found node
  private void replaceDoubleChildren(TreeNode currentNode, TreeNode parentNode) {
    TreeNode rightNode = currentNode.right;
    if (rightNode.left == null) {
      rightNode.left = currentNode.left;
      if (currentNode.value.isSmaller(parentNode.value)) {
        parentNode.left = currentNode.right;
      } else {
        parentNode.right = currentNode.right;
      }
    } else {
      TreeNode leftNode = rightNode.left;
      TreeNode parentOfLeft = rightNode;
      while (leftNode.left != null) {
        parentOfLeft = leftNode;
        leftNode = leftNode.left;
      }
      leftNode.left = currentNode.left;
      parentOfLeft.left = leftNode.right;
      if (currentNode.value.isSmaller(parentNode.value)) {
        parentNode.left = leftNode;
      } else {
        parentNode.right = leftNode;
      }
    }
  }

  private void replaceSingleChildRight(TreeNode currentNode, TreeNode parentNode) {
    if (parentNode == null) {
      this.root = currentNode.right;
    } else {
      if (currentNode.value.isSmaller(parentNode.value)) {
        parentNode.left = currentNode.right;
      } else {
        parentNode.right = currentNode.right;
      }
    }
  }

  private void replaceSingleChildLeft(TreeNode currentNode, TreeNode parentNode) {
    if (parentNode == null) {
      this.root = currentNode.left;
    } else {
      if (currentNode.value.isSmaller(parentNode.value)) {
        parentNode.left = currentNode.left;
      } else {
        parentNode.right = currentNode.left;
      }
    }
  }

  private boolean hasOnlyOneChild(TreeNode currentNode) {
    return (currentNode.left != null && currentNode.right == null)
        || (currentNode.right != null && currentNode.left == null);
  }

  private void removeLeaf(TreeNode currentNode, TreeNode parentNode) {
    if (parentNode != null) {
      if (parentNode.value.isSmaller(currentNode.value)) {
        parentNode.right = null;
      } else {
        parentNode.left = null;
      }
    }
  }
}

class MyNumber implements Compareable {
  protected final int number;

  public MyNumber(int val) {
    this.number = val;
  }

  @Override
  public boolean isSmaller(Object item) {
    return this.number < ((MyNumber) item).number;
  }

  @Override
  public boolean isEqual(Object item) {
    return this.number == ((MyNumber) item).number;
  }

  @Override
  public boolean isSmaller(Integer item) {
    return this.number < item;
  }

  @Override
  public boolean isEqual(Integer item) {
    return this.number == item;
  }

  @Override
  public String toString() {
    return "MyNumber{" + "number=" + number + '}';
  }
}

class TreeNode<T extends Compareable> {
  T value;
  TreeNode<T> left;
  TreeNode<T> right;

  public TreeNode(T value) {
    this.value = value;
  }

  public TreeNode() {}

  public void add(T value) {
    if (value.isSmaller(this.value)) {
      if (left == null) {
        left = new TreeNode<T>(value);
      } else {
        left.add(value);
      }
    } else {
      if (right == null) {
        right = new TreeNode<>(value);
      } else {
        right.add(value);
      }
    }
  }

  public TreeNode delete(TreeNode parent, int val) {

    if (val == ((MyNumber) this.value).number) {

      TreeNode<T> replacement = this.right;
      TreeNode<T> temp = this;

      if (this.left != null) {
        replacement = this.left;
        temp = this.left;
      }

      while (replacement.left != null) {
        temp = replacement;
        replacement = replacement.left;
      }

      if (replacement != null) {
        replacement.left = this.left;
        replacement.right = this.right;
        if (parent == null) {

        } else if (this == parent.right) {
          parent.right = replacement;
        } else {
          parent.left = replacement;
        }

        temp.left = null;
      }
      return this;
    } else if (this.left != null && val < ((MyNumber) this.value).number) {
      return this.left.delete(this, val);
    } else if (this.right != null) {
      return this.right.delete(this, val);
    } else {
      System.out.println("nothing to delete");
    }

    return null;
  }

  public void print() {
    System.out.println(this.value);
    if (left != null) {
      System.out.print("left ");
      left.print();
    }

    if (right != null) {
      System.out.print("right  ");
      right.print();
    }
  }

  @Override
  public String toString() {
    return "TreeNode{" +
            "value=" + value +
            '}';
  }

  public void printGraph(ListenableGraph<Integer, DefaultEdge> g) {
    g.addVertex(((MyNumber) this.value).number);
    if (left != null) {
      this.left.printGraph(g);
      g.addEdge(((MyNumber) this.value).number, ((MyNumber) this.left.value).number);
    }
    if (right != null) {
      this.right.printGraph(g);
      g.addEdge(((MyNumber) this.value).number, ((MyNumber) this.right.value).number);
    }
  }

  public TreeNode lookup(int v) {
    if (this.value.isEqual(v)) {
      return this;
    } else if (this.value.isSmaller(v) && this.right != null) {
      return this.right.lookup(v);
    } else if (left != null) {
      return this.left.lookup(v);
    }
    return null;
  }
}

interface Compareable<T> {
  boolean isSmaller(T item);

  boolean isEqual(T item);

  boolean isSmaller(Integer item);

  boolean isEqual(Integer item);
}
