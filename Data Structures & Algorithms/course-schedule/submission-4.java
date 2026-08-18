class Solution {
    public boolean canFinish(int numCourses, int[][] arr) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int n[]: arr) {
            int a = n[0];
            int b = n[1];
            if (!map.containsKey(b)) {
                map.put(b, new HashSet<>());
            }
            map.get(b).add(a);
        }
        Map<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, map, visited)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasCycle(int i, Map<Integer, Set<Integer>> map, Map<Integer, Integer> visited) {
        if (visited.containsKey(i) && visited.get(i) == 1) {
            return true;
        }
        if (visited.containsKey(i)) {
            return false;
        }
        visited.put(i, 1);
        for (int n: map.getOrDefault(i, new HashSet<>())) {
            if (hasCycle(n, map, visited)) {
                return true;
            }
        }
        visited.put(i, 2);
        return false;
    }
}
