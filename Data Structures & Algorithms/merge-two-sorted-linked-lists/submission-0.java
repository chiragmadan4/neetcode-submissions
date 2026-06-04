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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode ans = null;
        ListNode last = null;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                if (ans == null) {
                    ans = list1;
                    last = list1;
                } else {
                    last.next = list1;
                    last = last.next;
                }
                list1 = list1.next;
            } else {
                if (ans == null) {
                    ans = list2;
                    last = list2;
                } else {
                    last.next = list2;
                    last = last.next;
                }
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            last.next = list1;
        }
        if (list2 != null) {
            last.next = list2;
        }
        return ans;
        
    }
}