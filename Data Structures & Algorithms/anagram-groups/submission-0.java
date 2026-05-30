class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        
        Map<String, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = new String(strs[i]);
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            s = new String(arr);
            if (!map.containsKey(s)) {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                map.put(s, set);
            }
            map.get(s).add(i);
        }

        map.forEach((s, set) -> {
            List<String> subAns = new ArrayList<>();
            for (int i: set) {
                subAns.add(strs[i]);
            }
            ans.add(subAns);
        });
        return ans;
    }
}
