class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i: nums) {
            if (pq.size() < k) {
                pq.add(i);
                continue;
            }
            int top = pq.peek();
            if (i >= top) {
                pq.remove();
                pq.add(i);
            }
        }
    }
    
    public int add(int val) {
        if (pq.size() < k) {
            pq.add(val);
        } else {
            int top = pq.peek();
            if (val >= top) {
                pq.remove();
                pq.add(val);
            }
        }
        return pq.peek();
    }
}
