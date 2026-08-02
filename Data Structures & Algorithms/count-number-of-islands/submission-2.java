class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    traverse(grid, i, j);
                }
            }
        }
        return ans;
    }

    public void traverse(char grid[][], int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir: dirs) {
            traverse(grid, i + dir[0], j + dir[1]);
        }
    }
}
