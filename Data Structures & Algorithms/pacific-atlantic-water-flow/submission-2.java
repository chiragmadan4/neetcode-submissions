class Node {
    int i;
    int j;
    Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
class Solution {
    int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean visitedp[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            traverse(i, 0, heights, visitedp);
        }
        for (int j = 0; j < n; j++) {
            traverse(0, j, heights, visitedp);
        }
        boolean visiteda[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            traverse(i, n - 1, heights, visiteda);
        }
        for (int j = 0; j < n; j++) {
            traverse(m - 1, j, heights, visiteda);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visiteda[i][j] && visitedp[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    public void traverse(int i, int j, int[][] heights, boolean[][] visited) {
        int m = heights.length;
        int n = heights[0].length;
        visited[i][j] = true;
        for (int dir[]: dirs) {
            int a = i + dir[0];
            int b = j + dir[1];
            if (a < 0 || a >= m || b < 0 || b >= n || visited[a][b]) {
                continue;
            }
            if (heights[a][b] >= heights[i][j]) {
                traverse(a, b, heights, visited);
            }
        }
    }
}
