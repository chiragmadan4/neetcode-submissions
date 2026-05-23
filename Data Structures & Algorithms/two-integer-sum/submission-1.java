class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0 ; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int idx = map.get(target - nums[i]);
                if (idx == i) {
                    continue;
                }
                if (idx < i) {
                    return new int[]{idx, i};
                } else {
                    return new int[]{i, idx};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
