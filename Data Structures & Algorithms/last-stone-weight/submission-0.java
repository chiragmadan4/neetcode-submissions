class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i: stones) {
            pq.add(i);
        }
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a == b) {
                continue;
            }
            pq.add(Math.abs(b - a));
        }
        if (pq.size() == 0) {
            return 0;
        } else {
            return pq.poll();
        }        
    }
}
