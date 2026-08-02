class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean visited[][] = new boolean[row][col];

        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    ans++;
                    traverse(grid, i, j, visited);
                }
            }
        }
        return ans;
    }

    public void traverse(char grid[][], int i, int j, boolean visited[][]) {
        int row = grid.length;
        int col = grid[0].length;
        visited[i][j] = true;
        if (i + 1 < row && grid[i + 1][j] == '1' && !visited[i + 1][j]) {
            traverse(grid, i + 1, j, visited);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == '1' && !visited[i - 1][j]) {
            traverse(grid, i - 1, j, visited);
        }
        if (j + 1 < col && grid[i][j + 1] == '1' && !visited[i][j + 1]) {
            traverse(grid, i, j + 1, visited);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1' && !visited[i][j - 1]) {
            traverse(grid, i, j - 1, visited);
        }
    }
}
