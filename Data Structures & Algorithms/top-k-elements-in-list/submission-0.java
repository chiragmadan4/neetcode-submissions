class Pair{
    int val;
    int freq;
    public Pair(int val, int freq) {
        this.val = val;
        this.freq = freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    return p2.freq - p1.freq;
                }
            }
        );
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i: map.keySet()) {
            pq.add(new Pair(i, map.get(i)));
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            Pair p = pq.poll();
            ans[i] = p.val;
        }
        return ans;
    }
}
