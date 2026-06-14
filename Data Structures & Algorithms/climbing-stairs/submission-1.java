class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return fetch(0, n, map);
    }
    public int fetch(int i, int n, Map<Integer, Integer> map) {
        if (i == n) {
            return 1;
        }
        if (map.containsKey(i)) {
            return map.get(i);
        }
        int a2 = 0;
        int a1 = fetch(i + 1, n, map);
        if (n - i > 1) {
            a2 = fetch(i + 2, n, map);
        }
        map.put(i, a1 + a2);
        return a1 + a2;
    }
}
