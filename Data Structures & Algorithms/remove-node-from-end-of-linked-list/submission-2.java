/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode left = head;
        ListNode right = head;
        while (n > 0) {
            right = right.next;
            n--;
        }
        ListNode prev = null;
        while (right != null) {
            prev = left;
            left = left.next;
            right = right.next;
        }
        if (prev == null) {
            return head.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}
