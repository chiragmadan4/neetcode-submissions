class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int a = Math.abs(nums[i]);
            if (nums[a] < 0) {
                return a;
            }
            nums[a] = -1 * nums[a];
        }
        return -1;
    }
}
