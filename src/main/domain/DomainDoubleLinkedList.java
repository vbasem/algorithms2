package main.domain;

public class DomainDoubleLinkedList {
  DoubleNode head;
  DoubleNode tail;
  int size = 0;

  public static void main(String[] args) {
    DomainDoubleLinkedList dd = new DomainDoubleLinkedList();
    dd.add(1);
    dd.add(3);
    dd.add(5);
    dd.add(7);
    dd.prepend(7);
    dd.insert(2, 4);
    dd.delete(3);

    dd.printAll();
    System.out.println("-----");
    dd.reversePrintAll();
  }

  public DomainDoubleLinkedList() {}

  public DomainDoubleLinkedList add(int num) {
    DoubleNode newDoubleNode = new DoubleNode(num);
    if (this.head == null) {
      this.head = newDoubleNode;
      this.tail = newDoubleNode;
    } else {
      newDoubleNode.previous = this.tail;
      this.tail.next = newDoubleNode;
      this.tail = newDoubleNode;

    }
    size++;
    return this;
  }

  public void prepend(int v) {
    DoubleNode newDoubleNode = new DoubleNode(v);
    if (this.head == null) {
      this.head = newDoubleNode;
      this.tail = newDoubleNode;
    } else {
      this.head.previous = newDoubleNode;
      newDoubleNode.next = this.head;
      this.head = newDoubleNode;
    }
    size++;
  }

  public void insert(int location, int value) {

    if (location > size) {
      this.add(value);
    } else if (location == 0) {
      this.prepend(value);
    } else {
      DoubleNode newDoubleNode = new DoubleNode(value);
      DoubleNode previousDoubleNodeToLocation = getPreviousDoubleNodeToLocation(location);

      swapDoubleNodes(newDoubleNode, previousDoubleNodeToLocation);
    }
  }

  public int delete(int location) {
    if (location == 0) {
      DoubleNode DoubleNode = this.head;
      this.head = this.head.next;
      if (this.head != null) {
        this.head.previous = null;
      }
      return DoubleNode.value;
    } else if (location == size - 1) {
      DoubleNode DoubleNode = this.tail;
      DoubleNode previousDoubleNodeToLocation = getPreviousDoubleNodeToLocation(location);
      previousDoubleNodeToLocation.next = null;

      this.tail = previousDoubleNodeToLocation;
      return DoubleNode.value;
    } else {
      DoubleNode previousDoubleNodeToLocation = getPreviousDoubleNodeToLocation(location);
      DoubleNode DoubleNode = previousDoubleNodeToLocation.next;
      DoubleNode.next.previous = previousDoubleNodeToLocation;
      previousDoubleNodeToLocation.next = DoubleNode.next;
      return DoubleNode.value;
    }
  }

  private DoubleNode getPreviousDoubleNodeToLocation(int location) {
    DoubleNode previousDoubleNodeToLocation = this.head;
    int counter = 0;
    while (counter < location) {
      previousDoubleNodeToLocation = previousDoubleNodeToLocation.next;
      counter++;
    }
    return previousDoubleNodeToLocation;
  }

  private void swapDoubleNodes(DoubleNode newDoubleNode, DoubleNode currentDoubleNodeAtLocation) {
    newDoubleNode.previous = currentDoubleNodeAtLocation;
    newDoubleNode.next = currentDoubleNodeAtLocation.next;
    currentDoubleNodeAtLocation.next = newDoubleNode;
  }

  public void printAll() {
    DoubleNode DoubleNode = this.head;
    while (DoubleNode != null) {
      System.out.println(DoubleNode.value);
      DoubleNode = DoubleNode.next;
    }
  }


  public void reversePrintAll() {
    DoubleNode DoubleNode = this.tail;
    while (DoubleNode != null) {
      System.out.println(DoubleNode.value);
      DoubleNode = DoubleNode.previous;
    }
  }
}

class DoubleNode {
  DoubleNode next;
  DoubleNode previous;
  int value;

  public DoubleNode(int v) {
    this.value = v;
  }
}
