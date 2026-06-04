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
    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode temp = slow.next;
        slow.next = null;
        Stack<ListNode> stack = new Stack<>();
        while (temp != null) {
            stack.add(temp);
            temp = temp.next;
        }

        ListNode last = head;
        while (!stack.isEmpty()) {
            ListNode top = stack.pop();
            ListNode temp1 = last.next;
            last.next = top;
            top.next = temp1;
            last = temp1;
        }
    }
}
