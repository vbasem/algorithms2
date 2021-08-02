package main.domain;

public class DomainStack {

    public void testPushPop() {
        DomainStack stack = 		new DomainStack();
        stack.push(1);
        int result = stack.pop();
        System.out.println("result: " + result);
        assert result == 1: "result of pop didnt match";

    }

    public void testPopNull() {
        DomainStack stack = 		new DomainStack();


        int result = stack.pop();
        System.out.println("result: " + result);
        assert result == 0: "result of pop didnt match";

    }

    public static void main(String[] args) {
        DomainStack stack = new DomainStack();
        stack.testPushPop();
        stack.testPopNull();

        stack.push(3);
        System.out.println("result: " + stack.peek());
        stack.push(4);
        stack.push(3);

        System.out.println("result: " + stack.pop());
        System.out.println("result: " + stack.pop());
        System.out.println("result: " + stack.pop());
        System.out.println("result: " +  stack.pop());


    }

    int[] data;
    int last;

    public DomainStack() {
        this.data = new int[100];
    }

    public void push(int v ) {
        this.data[last++] = v;
    }

    public int pop() {
        if (this.last == 0) {
            return 0;
        } else {
            return this.data[--last];
        }

    }

    public int peek()  {
        if (this.last == 0) {
            return 0;
        } else {
            return this.data[last - 1];
        }
    }
}
