class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
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
        boolean visited[] = new boolean[n];
        traverse(0, map, visited);
        for (boolean v: visited) {
            if (!v) {
                return false;
            }
        }
        return true;
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
