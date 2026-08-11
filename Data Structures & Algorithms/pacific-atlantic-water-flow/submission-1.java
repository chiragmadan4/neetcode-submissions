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
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (traverse(heights, i, j)) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
    public boolean traverse(int arr[][], int i, int j) {
        int m = arr.length;
        int n = arr[0].length;
        boolean visited[][] = new boolean[arr.length][arr[0].length];
        boolean p = false;
        boolean a = false;
        Queue<Node> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.add(new Node(i, j));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int dir[]: dirs) {
                int r = node.i + dir[0];
                int c = node.j + dir[1];

                // System.out.println(i + " " + j + " " + r + " " + c);
                boolean skip = false;
                if (r < 0 || c < 0) {
                    p = true;
                    if (p && a) {
                        return true;
                    }
                    skip = true;
                }
                if (r >= m || c >= n) {
                    a = true;
                    if (p && a) {
                        return true;
                    }
                    skip = true;
                }
                if (skip || visited[r][c]) {
                    continue;
                }
                if (arr[r][c] > arr[node.i][node.j]) {
                    continue;
                }
                visited[r][c] = true;
                queue.add(new Node(r, c));
            }
        }
        return false;
    }
}
