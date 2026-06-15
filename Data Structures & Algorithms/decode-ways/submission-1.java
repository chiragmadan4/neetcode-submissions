class Solution {
    public int numDecodings(String s) {
        Map<String, Integer> map = new HashMap<>();
        return fetch(s, map);
    }

    public int fetch(String s, Map<String, Integer> map) {
        if (s.length() == 0) {
            return 1;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        int ans = 0;
        int a = fetch(s.substring(1), map);
        ans += a;
        String t = s.charAt(0) + "" + s.charAt(1);
        if (isValid(t)) {
            int b = fetch(s.substring(2), map);
            ans += b;
        }
        map.put(s, ans);
        return ans;
    }

    public boolean isValid(String s) {
        int i = Integer.parseInt(s);
        return i <= 26;
    }
}
