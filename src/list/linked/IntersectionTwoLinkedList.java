package list.linked;

import list.ListNode;

public class IntersectionTwoLinkedList {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);

        new IntersectionTwoLinkedList().getIntersectionNode(a, b);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int i = 1, j = 1, k = 0;
        ListNode a = headA, b = headB;

        while (a.next != null) {
            i++;
            a = a.next;
        }

        while (b.next != null) {
            j++;
            b = b.next;
        }

        k = Math.abs(i - j);
        a = headA;
        b = headB;
        for (int q = 0; q < k; q++) {
            if (i < j) b = b.next;
            else a = a.next;
        }

        while (a.next != null && b.next != null) {
            if (a.next.hashCode() == b.next.hashCode()) return a.next;
            a = a.next;
            b = b.next;
        }

        return null;
    }
}
