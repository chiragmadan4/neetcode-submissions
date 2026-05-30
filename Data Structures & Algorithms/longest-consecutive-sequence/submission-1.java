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
            if (map.get(i) == true) {
                continue;
            }
            int len = 1;
            int start = i;
            int candidate = start + 1;
            while (true) {
                if (!map.containsKey(candidate)) {
                    break;
                }
                map.put(candidate, true);
                len++;
                candidate++;
                maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen;
        
    }
}
