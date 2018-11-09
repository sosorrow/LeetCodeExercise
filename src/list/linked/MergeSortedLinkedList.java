package list.linked;

import list.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeSortedLinkedList {

    public static void main(String[] args) {
        ListNode[] list = new ListNode[3];

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(5);
        l2.next = l3;
        l1.next = l2;

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l5.next = l6;
        l4.next = l5;

        ListNode l7 = new ListNode(2);
        ListNode l8 = new ListNode(6);
        l7.next = l8;

        list[0] = l1;
        list[1] = l4;
        list[2] = l7;

        new MergeSortedLinkedList().mergeKLists(list);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode r = null;
        Map<Integer, ArrayList<ListNode>> m = new HashMap<>();
        List<Integer> sort = new ArrayList<>();

        ListNode n;
        for (ListNode l : lists) {
            n = l;
            while(n != null) {
                if (!m.containsKey(n.val)) {
                    m.put(n.val, new ArrayList<>());
                }
                m.get(n.val).add(n);
                if (!sort.contains(n.val)) sort.add(n.val);
                n = n.next;
            }
        }

        n = null;
        sort.sort((a, b) -> a < b ? -1 : 1);
        for (int i : sort) {
            for (ListNode q: m.get(i)) {
                if (r == null) {
                    r = q;
                    n = r;
                } else {
                    n.next = q;
                    n = n.next;
                }
            }
        }

        return r;
    }
}
