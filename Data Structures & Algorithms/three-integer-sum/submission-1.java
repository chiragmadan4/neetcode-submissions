class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        for (int q = 0; q < n - 2; q++) {
            if (q > 0 && nums[q] == nums[q-1]) {
                continue;
            }
            int target = -1 * nums[q];

            int i = q + 1;
            int j = n - 1;

            while (i < j) {
                int sum = nums[i] + nums[j];
                if (sum < target) {
                    i++;
                } else if (sum > target) {
                    j--;
                } else {
                    List<Integer> subAns = new ArrayList<>();
                    subAns.add(nums[q]);
                    subAns.add(nums[i]);
                    subAns.add(nums[j]);
                    ans.add(subAns);
                    i++;
                    j--;
                    while (nums[i] == nums[i -1] && i < j) {
                        i++;
                    }
                }
            }
        }
        return ans;
    }
}
