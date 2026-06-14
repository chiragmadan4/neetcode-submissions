class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        ans[n - 1] = nums[n - 1];
        ans[n - 2] = nums[n - 2];
        for (int i = n - 3; i >= 0; i--) {
            ans[i] = Math.max(ans[i + 1], ans[i + 2] + nums[i]);
        }
        return ans[0];
    }
}
