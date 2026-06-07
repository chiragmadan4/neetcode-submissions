class Pair {
    int idx;
    int d;
    Pair(int idx, int d) {
        this.idx = idx;
        this.d = d;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    return p2.d - p1.d;
                }
            }
        );

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int d = x * x + y * y;
            pq.add(new Pair(i, d));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            ans[i] = points[p.idx];
            i++;
        }
        return ans;
    }
}
