class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int ans = Integer.MAX_VALUE;
        int max = piles[0];
        for (int i: piles) {
            max = Math.max(i, max);
        }
        int l = 1;
        int r = max;

        while (l <= r) {
            int k = (l + r) / 2;
            int time = time(piles, k);
            if (time <= h) {
                ans = Math.min(ans, k);
                r = k - 1;
            }
            if (time > h) {
                l = k + 1;
            }
        }
        return ans;
    }

    public int time(int[] arr, int k) {
        int time = 0;
        for (int i: arr) {
            time += Math.ceil(i * 1.0 / k);
        }
        return time;
    }
}
