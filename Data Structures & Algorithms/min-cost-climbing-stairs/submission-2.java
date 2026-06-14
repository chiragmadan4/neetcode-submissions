class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Map<Integer, Integer> map = new HashMap<>();
        return fetch(cost, -1, map);
    }
    public int fetch(int arr[], int i, Map<Integer, Integer> map) {
        if (i >= arr.length) {
            return 0;
        }
        if (map.containsKey(i)) {
            return map.get(i);
        }
        int op1 = fetch(arr, i + 1, map);
        int op2 = fetch(arr, i + 2, map);
        if (i == -1) {
            return Math.min(op1, op2);
        }
        map.put(i, Math.min(op1, op2) + arr[i]);
        return Math.min(op1, op2) + arr[i];
    }
}
