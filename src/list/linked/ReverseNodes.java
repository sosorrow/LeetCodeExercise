package list.linked;

import list.ListNode;

public class ReverseNodes {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;

        ListNode result = new ReverseNodes().reverseKGroup(l1, 3);
        ListNode n = result;
        while (n != null) {
            System.out.print(n.val + "  ");
            n = n.next;
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k==1) return head;
        int i = 1, j = 0;
        ListNode h = null, r = null, e = head, p = null, c = head, n = head.next;
        while (c != null) {
            j++;
            c = c.next;
        }
        if (j < k) return head;
        j -= j % k;
        c = head;
        System.out.println(j);
        while (n != null || i <= j) {
            c.next = p;
            if (i % k == 0) {
                if (h != null) h.next = c;
                h = e;
                e = n;
                if (i == k) {
                    r = c;
                }
                if (i == j) {
                    h.next = n;
                    h = null;
                    break;
                }

                p = null;
            } else {
                p = c;
            }
            c = n;
            n = n.next;
            i++;
        }
//        c.next = p;
//        if (h != null) h.next = c;
//        else r = c;

        return r;
    }
}
