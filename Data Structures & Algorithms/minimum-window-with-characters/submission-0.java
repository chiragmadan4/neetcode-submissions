class Solution {
    public String minWindow(String s, String t) {
        Map<Integer, Integer> tmap = new HashMap<>();
        for (char c: t.toCharArray()) {
            tmap.put((int) c, tmap.getOrDefault((int) c, 0) + 1);
        }
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            Map<Integer, Integer> map = new HashMap<>();
            if (!tmap.containsKey((int) s.charAt(i))) {
                continue;
            }
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                int ci = (int) c;
                map.put(ci, map.getOrDefault(ci, 0) + 1);
                if (tmap.containsKey(ci) && map.get(ci) >= tmap.get(ci)) {
                    set.add((int) s.charAt(j));
                }
                if (set.size() >= tmap.size()) {
                    if (ans.equals("") || s.substring(i, j + 1).length() < ans.length()) {
                        ans = s.substring(i, j + 1);
                    }
                }

            }
        }
        return ans;
        
    }
}
