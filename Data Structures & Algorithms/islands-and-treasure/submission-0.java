class Node {
    int i;
    int j;
    Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    traverse(i, j, grid);
                }
            }
        }
    }

    public void traverse(int i, int j, int[][] grid) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[i][j] = true;
        queue.add(new Node(i, j));
        int dist = 0;
        while (!queue.isEmpty()) {
            dist++;
            int len = queue.size();
            while (len > 0) {
                Node node = queue.poll();
                for (int[] dir: dirs) {
                    int a = node.i + dir[0];
                    int b = node.j + dir[1];
                    if (a < 0 || a >= grid.length || b < 0 || b >= grid[0].length || visited[a][b]) {
                        continue;
                    }
                    if (grid[a][b] != 0 && grid[a][b] != -1) {
                        grid[a][b] = Math.min(grid[a][b], dist);
                        visited[a][b] = true;
                        queue.add(new Node(a, b));
                    }
                }
                len--;
            }
        }
    }
}
