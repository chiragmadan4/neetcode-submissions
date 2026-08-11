class Node {
    int i;
    int j;
    Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Node> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new Node(i, j));
                }
            }
        }
        int dist = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            dist++;
            while (len > 0) {
                Node node = queue.poll();
                for (int dir[]: dirs) {
                    int r = node.i + dir[0];
                    int c = node.j + dir[1];
                    if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != Integer.MAX_VALUE) {
                        continue;
                    }
                    grid[r][c] = dist;
                    queue.add(new Node(r, c));
                }
                len--;
            }
        }
    }
}
