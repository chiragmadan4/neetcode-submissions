class Node {
    int val;
    int key;
    Node prev;
    Node next;
    public Node(int key, int val) {
        this.val = val;
        this.key = key;
    }
}

class LRUCache {
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;

        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            Node prev = node.prev;
            prev.next = node.next;
            node.next.prev = prev;

            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
        } else {
            Node node = new Node(key, value);
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            map.put(key, node);
            if (map.size() > capacity) {
                map.remove(head.next.key);
                Node toBeRemoved = head.next;
                head.next = toBeRemoved.next;
                toBeRemoved.next.prev = head;
            }
        }
    }
}
