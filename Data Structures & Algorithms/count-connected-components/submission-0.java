class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean visited[] = new boolean[n];
        int ans = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int e[]: edges) {
            int a = e[0];
            int b = e[1];
            if (!map.containsKey(a)) {
                map.put(a, new HashSet<>());
            }
            if (!map.containsKey(b)) {
                map.put(b, new HashSet<>());
            }
            map.get(a).add(b);
            map.get(b).add(a);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                traverse(i, map, visited);
                ans++;
            }
        }
        return ans;
    }
    public void traverse(int i, Map<Integer, Set<Integer>> map, boolean visited[]) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int n: map.getOrDefault(i, new HashSet<>())) {
            traverse(n, map, visited);
        }
    }
}
