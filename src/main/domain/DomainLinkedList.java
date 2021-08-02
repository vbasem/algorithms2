package main.domain;

public class DomainLinkedList {
  Node head;
  Node tail;
  int size = 0;

  public static void main(String[] args) {
    DomainLinkedList dd = new DomainLinkedList();
    dd.add(1);
    dd.add(3);
    dd.add(5);
    dd.add(7);
    dd.prepend(7);
    dd.insert(2, 4);
    dd.delete(3);

    dd.printAll();
    dd.reverse();
    System.out.println("----");
    dd.printAll();
    System.out.println("----");
    dd.reverseInPlace();
    dd.printAll();

  }

  public DomainLinkedList() {}

  public DomainLinkedList add(int num) {
    Node newNode = new Node(num);
    if (this.head == null) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      this.tail.next = newNode;
      this.tail = newNode;
    }
    size++;
    return this;
  }

  public void prepend(int v) {
    Node newNode = new Node(v);
    if (this.head == null) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      newNode.next = this.head;
      this.head = newNode;
    }
    size++;
  }

  public void insert(int location, int value) {

    if (location > size) {
      this.add(value);
    } else if (location == 0) {
      this.prepend(value);
    } else {
      Node newNode = new Node(value);
      Node previousNodeToLocation = getPreviousNodeToLocation(location);

      swapNodes(newNode, previousNodeToLocation);
    }
  }

  public int delete(int location) {
    if (location == 0) {
      Node node = this.head;
      this.head = this.head.next;
      return node.value;
    } else if (location == size - 1) {
      Node node = this.tail;
      Node previousNodeToLocation = getPreviousNodeToLocation(location);
      previousNodeToLocation.next = null;

      this.tail = previousNodeToLocation;
      return node.value;
    } else {
      Node previousNodeToLocation = getPreviousNodeToLocation(location);
      Node node = previousNodeToLocation.next;
      previousNodeToLocation.next = node.next;
      return node.value;
    }
  }

  private Node getPreviousNodeToLocation(int location) {
    Node previousNodeToLocation = this.head;
    int counter = 0;
    while (counter < location) {
      previousNodeToLocation = previousNodeToLocation.next;
      counter++;
    }
    return previousNodeToLocation;
  }

  private void swapNodes(Node newNode, Node currentNodeAtLocation) {
    newNode.next = currentNodeAtLocation.next;
    currentNodeAtLocation.next = newNode;
  }

  public void printAll() {
    Node node = this.head;
    while (node != null) {
      System.out.println(node.value);
      node = node.next;
    }
  }

  public DomainLinkedList reverse() {
    Node[] items = new Node[this.size];

    Node node = this.head;
    int index = 0;
    while (node != null) {
      this.delete(0);
      items[index++] = node;
      node = node.next;
    }

    for (int i = items.length - 1; i >= 0; i--) {
      this.add(items[i].value);
    }

    return this;
  }

  protected DomainLinkedList reverseInPlace() {
    if (this.size < 2) {
      return this;
    }

    Node first = this.head;
    Node second = this.head.next;
    this.head = this.tail;
    this.tail = first;
    this.tail.next = null;


    while (second != null) {
      Node temp = second.next;
      second.next = first;
      first = second;
      second = temp;
    }


    return this;
  }
}

class Node {
  Node next;
  int value;

  public Node(int v) {
    this.value = v;
  }
}
