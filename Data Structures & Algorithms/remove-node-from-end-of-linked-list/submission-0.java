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
        ListNode temp = head;
        if (head.next == null) {
            return null;
        }
        int i = 0;
        while (temp != null) {
            i++;
            temp = temp.next;
        }

        int x = i - n + 1;
        if (x == 1) {
            return head.next;
        }
        i = 0;
        temp = head;
        while (true) {
            i++;
            if (i == x - 1) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
}
