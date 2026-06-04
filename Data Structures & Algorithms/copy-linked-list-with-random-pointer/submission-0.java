/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node ans = new Node(head.val);
        map.put(head, ans);
        Node temp1 = head;
        Node temp2 = ans;
        temp1 = temp1.next;
        while (temp1 != null) {
            temp2.next = new Node(temp1.val);
            temp2 = temp2.next;
            map.put(temp1, temp2);
            temp1 = temp1.next;
        }

        temp1 = head;
        while (temp1 != null) {
            Node r = temp1.random;
            if (r != null) {
                map.get(temp1).random = map.get(r);
            }
            temp1 = temp1.next;
        }
        return ans;
    }
}
