class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int s = 0;
        int e = n - 1;
        int row = -1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (target > matrix[mid][0]) {
                if (mid == n - 1) {
                    row = n - 1;
                    break;
                }
                if (target <= matrix[mid][m - 1]) {
                    row = mid;
                    break;
                }
                s = mid + 1;
            } else if (target < matrix[mid][0]) {
                if (mid == 0) {
                    return false;
                }
                if (target >= matrix[mid - 1][0]) {
                    row = mid - 1;
                    break;
                }
                e = mid - 1;
            } else {
                return true;
            }
        }
        if (row == -1) {
            return false;
        }

        for (int i = 0; i < m; i++) {
            if (matrix[row][i] == target) {
                return true;
            }
        }
        return false;
        
    }
}
