class Solution {
    public int maxProfit(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }
        int n = arr.length;
        int min = arr[0];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int profit = Math.max(0, arr[i] - min);
            min = Math.min(arr[i], min);
            ans = Math.max(ans, profit);
        }
        return ans;
        
    }
}
