class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (n == 3) {
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }
        int ans[] = new int[n];
        ans[1] = nums[1];
        ans[2] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < n; i++) {
            ans[i] = Math.max(ans[i - 1], ans[i - 2] + nums[i]);
        }
        int op1 = ans[n - 1];
        ans = new int[n];
        ans[0] = nums[0];
        ans[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            ans[i] = Math.max(ans[i - 1], ans[i - 2] + nums[i]);
        }
        int op2 = ans[n - 2];
        return Math.max(op1, op2);
    }
}
