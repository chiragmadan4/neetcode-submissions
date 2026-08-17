class Node {
    int i;
    int j;
    Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public void solve(char[][] arr) {
        int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = arr.length;
        int n = arr[0].length;
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (arr[i][0] == 'O') {
                queue.add(new Node(i, 0));
            }
            if (arr[i][n - 1] == 'O') {
                queue.add(new Node(i, n - 1));
            }
        }
        for (int j = 0; j < n; j++) {
            if (arr[0][j] == 'O') {
                queue.add(new Node(0, j));
            }
            if (arr[m-1][j] == 'O') {
                queue.add(new Node(m - 1, j));
            }
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int r = node.i;
            int c = node.j;
            if (r < 0 || r >= m || c < 0 || c >= n || arr[r][c] != 'O') {
                continue;
            }
            arr[r][c] = 'Y';
            for (int dir[]: dirs) {
                int a = node.i + dir[0];
                int b = node.j + dir[1];
                queue.add(new Node(a, b));
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'Y') {
                    arr[i][j] = 'O';
                } else if (arr[i][j] == 'O') {
                    arr[i][j] = 'X';
                }
            }
        }
    }
}
