class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int op = traverse(grid, i, j);
                    ans = Math.max(op, ans);
                }
            }
        }
        return ans;
    }
    public int traverse(int grid[][], int i, int j) {
        int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        int ans = 1;
        for (int dir[]: dirs) {
            ans += traverse(grid, i + dir[0], j + dir[1]);
        }
        return ans;
    }
}
