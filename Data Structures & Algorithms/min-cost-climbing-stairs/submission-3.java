class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int ans[] = new int[n + 1];
        ans[0] = cost[0];
        ans[1] = cost[1];
        for (int i = 2; i < ans.length; i++) {
            int op1 = ans[i - 2];
            int op2 = ans[i - 1];
            if (i == n) {
                return Math.min(op1, op2);
            }
            ans[i] = Math.min(op1, op2) + cost[i];
        }
        return 0;
    }
}
