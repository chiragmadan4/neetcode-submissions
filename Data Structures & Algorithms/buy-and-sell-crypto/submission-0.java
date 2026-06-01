class Solution {
    public int maxProfit(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }
        int n = arr.length;
        int rmax[] = new int[n];
        int max = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rmax[i] = max;
            max = Math.max(max, arr[i]);
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int profit = Math.max(0, rmax[i] - arr[i]);
            ans = Math.max(ans, profit);
        }
        return ans;
        
    }
}
