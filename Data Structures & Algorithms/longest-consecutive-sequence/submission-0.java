class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i: nums) {
            map.put(i, false);
        }
        int maxLen = 1;
        for (int i: nums) {
            int len = 1;
            int start = i;
            int candidate = start + 1;
            while (true) {
                if (!map.containsKey(candidate)) {
                    break;
                }
                len++;
                candidate++;
                maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen;
        
    }
}
