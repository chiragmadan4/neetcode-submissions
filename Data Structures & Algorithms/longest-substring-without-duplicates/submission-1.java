class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }
        int ans = 0, l = 0, r = 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put((int) s.charAt(l), 0);
        while(r < n) {
            if (map.containsKey((int) s.charAt(r))) {
                while (true) {
                    if (s.charAt(l) == s.charAt(r)) {
                        map.remove((int) s.charAt(l));
                        l = l + 1;
                        break;
                    }
                    map.remove((int) s.charAt(l));
                    l++;
                }
            } else {
                ans = Math.max(ans, r - l + 1);
                map.put((int) s.charAt(r), 0);
                r++;
            }

        }
        return ans;
    }
}
