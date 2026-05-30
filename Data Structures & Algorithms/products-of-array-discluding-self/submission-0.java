class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int lp[] = new int[n];
        lp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            lp[i] = lp[i - 1] * nums[i];
        }

        int rp[] = new int[n];
        rp[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rp[i] = rp[i + 1] * nums[i];
        }
        ans[0] = rp[1];
        ans[n - 1] = lp[n - 2];
        for (int i = 1; i < n - 1; i++) {
            ans[i] = lp[i - 1] * rp[i + 1];
        }
        return ans;
    }
}  
