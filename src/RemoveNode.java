

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class RemoveNode {
    public static void main(String[] args) {
        RemoveNode.ListNode h1 = new RemoveNode.ListNode(1);
        RemoveNode.ListNode h2 = new RemoveNode.ListNode(2);
        RemoveNode.ListNode h3 = new RemoveNode.ListNode(3);
        RemoveNode.ListNode h4 = new RemoveNode.ListNode(4);
        RemoveNode.ListNode h5 = new RemoveNode.ListNode(5);
        h4.next = h5;
        h3.next = h4;
        h2.next = h3;
        h1.next = h2;

        RemoveNode.ListNode h = new RemoveNode().removeNthFromEnd(h1, 2);

        RemoveNode.ListNode hh = h;
        while(hh != null) {
            if (hh != null) System.out.println(hh.val);
            hh = hh.next;
        }
    }

    /**
     * 11ms
     */
    private int n = 0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) return null;
        this.n = n;
        head = check(head);
        return head;
    }

    private ListNode check(ListNode head) {
        if (head.next != null) head.next = check(head.next);
        this.n--;
        if (this.n == 0) {
            return head.next;
        }
        return head;
    }

    /**
     * --     7ms     --
     */
    public ListNode removeNthFromEnd_7ms(ListNode head, int n) {
        ListNode ptr1, ptr2;
        ptr1 = ptr2 = head;
        while (n-- > 0)
            ptr2 = ptr2.next;
        if (ptr2 == null) {
            return head.next;
        } else {
            while (ptr2.next != null) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            ptr1.next = ptr1.next.next;
            return head;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}