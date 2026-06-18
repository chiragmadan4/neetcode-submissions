class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int product = nums[i];
            max = Math.max(max, product);
            for (int j = i + 1; j < n; j++) {
                product = product * nums[j];
                max = Math.max(max, product);
            }
        }
        return max;
    }
}
