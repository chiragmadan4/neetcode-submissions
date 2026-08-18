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
        for (int i = 0; i < numCourses; i++) {
            Set<Integer> visited = new HashSet<>();
            if (hasCycle(i, i, map, visited)) {
                System.out.println(i);
                return false;
            }
        }
        return true;
    }

    public boolean hasCycle(int s, int i, Map<Integer, Set<Integer>> map, Set<Integer> visited) {
        if (visited.contains(i) && s == i) {
            return true;
        }
        if (visited.contains(i)) {
            return false;
        }
        visited.add(i);
        for (int n: map.getOrDefault(i, new HashSet<>())) {
            if (hasCycle(s, n, map, visited)) {
                return true;
            }
        }
        return false;
    }
}
