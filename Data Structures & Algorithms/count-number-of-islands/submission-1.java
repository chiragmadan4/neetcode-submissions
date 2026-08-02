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
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return;
        }
        grid[i][j] = '2';
        if (i + 1 < row && grid[i + 1][j] == '1') {
            traverse(grid, i + 1, j);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            traverse(grid, i - 1, j);
        }
        if (j + 1 < col && grid[i][j + 1] == '1') {
            traverse(grid, i, j + 1);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            traverse(grid, i, j - 1);
        }
    }
}
