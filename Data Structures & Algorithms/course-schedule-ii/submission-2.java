class Solution {
    public int[] findOrder(int numCourses, int[][] arr) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int n[]: arr) {
            int a = n[0];
            int b = n[1];
            if (!map.containsKey(b)) {
                map.put(b, new HashSet<>());
            }
            map.get(b).add(a);
            set.add(a);
        }
        if (set.size() == numCourses) {
            return new int[0];
        }
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            if (set.contains(i)) {
                continue;
            }
            if (traverse(i, map, visited, ans)) {
                return new int[0];
            }
        }
        Collections.reverse(ans);
        int a[] = new int[ans.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = ans.get(i);
        }
        return a;
    }
    public boolean traverse(int i, Map<Integer, Set<Integer>> map, Map<Integer, Integer> visited, List<Integer> subAns) {
        if (visited.containsKey(i) && visited.get(i) == 2) {
            return false;
        }
        if (visited.containsKey(i) && visited.get(i) == 1) {
            return true;
        }
        visited.put(i, 1);    
        for (int n: map.getOrDefault(i, new HashSet<>())) {
            if (traverse(n, map, visited, subAns)) {
                return true;
            }
        }
        subAns.add(i);
        visited.put(i, 2);
        return false;
    }
}
