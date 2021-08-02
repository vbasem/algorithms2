package main.domain;

public class DomainQueue {
  public static void main(String[] args) {
    DomainQueue queue = new DomainQueue();
    queue.enqueue(1);
    queue.enqueue(2);
    System.out.println("result: " + queue.dequeue());
    System.out.println("result: " + queue.dequeue());
    System.out.println("result: " + queue.dequeue());
  }

  // [1, 2, 3, 4]
  // index write, index first
  // index write == length , index write  = 0;

  int[] data = new int[2];
  int first = 0;
  int write = 0;

  public void enqueue(int num) {
    this.data[write++] = num;

    if (write == this.data.length) {
      this.write = 0;
    }
  }

  public int dequeue() {
    int result = this.data[first++];
    if (first == this.data.length) {
      this.write = 0;
    }
    if (first == this.data.length) {
      first = 0;
    }

    return result;
  }
}
