class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                if (check(sub)) {
                    ans = Math.max(ans, sub.length());
                }
            }
        }
        return ans;
    }

    public boolean check(String s) {
        Set<Integer> set = new HashSet<>();
        for (char c: s.toCharArray()) {
            if (set.contains((int) c)) {
                return false;
            }
            set.add((int) c);
        }
        return true;
    }
}
