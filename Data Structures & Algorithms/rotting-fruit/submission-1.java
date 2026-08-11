class Node {
    int i;
    int j;
    Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new Node(i, j));
                }
            }
        }
        if (count == 0) {
            return 0;
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
                    if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != 1) {
                        continue;
                    }
                    grid[r][c] = 2;
                    queue.add(new Node(r, c));
                    count--;
                    if (count == 0) {
                        return dist;
                    }
                }
                len--;
            }
        }
        return -1;
    }
}
