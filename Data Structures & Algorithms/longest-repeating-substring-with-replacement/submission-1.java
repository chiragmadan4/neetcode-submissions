class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + k; j <= n; j++) {
                String str = s.substring(i, j);
                int max = maxFreq(str);
                int remaining = str.length() - max;
                if (remaining <= k) {
                    ans = Math.max(ans, str.length());
                }
            }
        }
        return ans;
    }

    public int maxFreq(String str) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (char c: str.toCharArray()) {
            int ci = (int) c;
            map.put(ci, map.getOrDefault(ci, 0) + 1);
            max = Math.max(map.get(ci), max);
        }
        return max;
    }
}
