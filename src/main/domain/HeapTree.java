package main.domain;

public class HeapTree {

  int[] data = new int[100];
  int size = 0;

  public static void main(String[] args) {
    HeapTree heapTree = new HeapTree();
    heapTree.add(5);
    heapTree.add(10);
    heapTree.add(15);
    heapTree.add(20);
    heapTree.add(25);
    heapTree.delete();

    heapTree.bsf();
  }

  public void bsf() {

    for (int i = 0; i < size; i++) {
      System.out.printf( ( i % 2 > 0 ? "left: " : "right: ") + " %d\n", data[i]);
    }
  }

  public void dsf() {
    for (int i = size - 1; i >= 0; i--) {
      System.out.printf(  i % 2 > 0 ? "left: " : "right: " + " %d\n", data[i]);
    }
  }

  public void add(int v) {
    data[size++] = v;
    rebalance();
  }

  public Integer delete() {
    int deleteNode = data[0];

    data[0] = data[size - 1];
    int leftIndex = 1;
    int rightIndex = 2;

    while (leftIndex < size) {
      int parentIndex = leftIndex /2;
      if (rightIndex == size) {
        if (data[parentIndex] < data[leftIndex]) {
          swap(parentIndex, leftIndex);
        }
      } else {
        if (data[leftIndex] < data[rightIndex]) {
          if (data[parentIndex] < data[rightIndex]) {
            swap(parentIndex, rightIndex);
          }
        } else if (data[parentIndex] < data[leftIndex]) {
          swap(parentIndex, leftIndex);
        }
      }
      leftIndex = getLeftChildIndex(leftIndex);
      rightIndex++;
    }
    size--;
    return deleteNode;
  }
  // 0 -> 1, 2  1 -> 3, 5  2xi+1
  private int getLeftChildIndex(int leftIndex) {
    return leftIndex * 2 + 1;
  }

  private void rebalance() {

    // while parent != null
    // if v > parent
    // swap
    int childIndex = size - 1;
    int parentIndex = getParentIndex(childIndex);
    while (data[childIndex] > data[parentIndex]) {
      swap(childIndex, parentIndex);
      childIndex = parentIndex;
      parentIndex = getParentIndex(childIndex);
    }
  }
  // 0 ,1,2        child 2  2/2 -1
  protected int getParentIndex(int childIndex) {
    if (childIndex == 0) {
      return 0;
    }
    int temp = childIndex / 2;
    if (childIndex % 2 == 0) {
      return temp - 1;
    } else {
      return temp;
    }
  }

  private void swap(int childIndex, int parentIndex) {
    int temp = data[parentIndex];
    data[parentIndex] = data[childIndex];
    data[childIndex] = temp;
  }
}
