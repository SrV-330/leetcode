package lcd0002;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode lt = null;
        ListNode l3 = new ListNode(0, lt);
        ListNode lt1 = l3;
        int flg = 0;
        while (l1 != null && l2 != null) {
            int t = l1.val + l2.val + flg;
            flg = t / 10;
            lt = new ListNode(t % 10, null);
            lt1.next = lt;
            lt1 = lt1.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null) {
            while (l2 != null) {
                int t = l2.val + flg;
                flg = t / 10;
                lt = new ListNode(t % 10, null);
                lt1.next = lt;
                lt1 = lt1.next;
                l2 = l2.next;
            }
        }
        if (l2 == null) {
            while (l1 != null) {
                int t = l1.val + flg;
                flg = t / 10;
                lt = new ListNode(t % 10, null);
                lt1.next = lt;
                lt1 = lt1.next;
                l1 = l1.next;
            }
        }

        if (flg > 0) {
            lt = new ListNode(flg, null);
            lt1.next = lt;
        }
        return l3.next;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, null)));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))))));
        ListNode l3 = new Solution().addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.print(l3.val);
            l3 = l3.next;
            System.out.print(l3 == null ? "" : ",");
        }
    }
}
