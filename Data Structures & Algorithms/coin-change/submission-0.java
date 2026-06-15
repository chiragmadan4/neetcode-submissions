class Solution {
    int ans = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        fetch(coins, amount, 0, 0, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public void fetch(int arr[], int target, int i, int curr, int count) {
        if (i >= arr.length) {
            return;
        }
        if (curr > target) {
            return;
        }
        if (curr == target) {
            ans = Math.min(ans, count);
            return;
        }
        fetch(arr, target, i, curr + arr[i], count + 1);
        fetch(arr, target, i + 1, curr, count);
    }
}
