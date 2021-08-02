package reversedlinkedlist;

public class ReversedLinkedList {

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);

    node4.next = node5;
    node3.next = node4;
    node2.next = node3;
    node1.next = node2;

//    new ReversedLinkedList().reverse(node1);
    new ReversedLinkedList().reverseList(node1);
    ListNode n = node5;
    while (n != null) {
      System.out.print(n.val + " -> ");
      n = n.next;
    }
  }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

  public void reverse(ListNode head) {
    ListNode next = head.next;
    head.next = null;
    doReverse(head, next);
  }

  protected void doReverse(ListNode head, ListNode current) {
    if (current == null) {
      return;
    } else {

        //x->y->z
        // next = z
        // y->x->z
      ListNode next = current.next;
      current.next = head;
      doReverse(current, next);
    }
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode() {}

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
