class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int s = nums.length - k + 1;
        for (int i: nums) {
            pq.add(i);
            if (pq.size() > s) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
