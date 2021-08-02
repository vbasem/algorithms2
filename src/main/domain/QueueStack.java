package main.domain;

public class QueueStack {

  DomainStack stack = new DomainStack();
  int size = 0;

  public static void main(String[] args) {

    QueueStack queue = new QueueStack();

    queue.push(1);
    System.out.println(queue.pop());

    queue.push(3);
    queue.push(7);
    queue.push(9);
    queue.push(11);
    System.out.println(queue.pop());
    System.out.println(queue.pop());
    System.out.println(queue.pop());
    System.out.println(queue.pop());
    System.out.println(queue.pop());
  }

  public void push(int num) {
    int[] temp = new int[size];
    for (int i = 0; i < temp.length; i++) {
      temp[i] = this.stack.pop();
    }
    this.stack.push(num);
    for (int i = temp.length - 1; i >= 0; i--) {
      this.stack.push(temp[i]);
    }
    size++;
  }

  public int pop() {
    if (size > 0) {
      size--;
    }
    return this.stack.pop();
  }
}
