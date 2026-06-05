class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            System.out.println(mid);
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                l = mid + 1;
            }
            if (target < nums[mid]) {
                r = mid - 1;
            }
        }

        return -1;
    }
}
