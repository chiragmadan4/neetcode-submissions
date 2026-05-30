class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!checkRow(i, board)) {
                return false;
            }
            if (!checkCol(i, board)) {
                return false;
            }
        }
        if (!checkCell(0, 0, board)) {
            return false;
        }
        if (!checkCell(3, 0, board)) {
            return false;
        }
        if (!checkCell(6, 0, board)) {
            return false;
        }
        if (!checkCell(0, 3, board)) {
            return false;
        }
        if (!checkCell(0, 6, board)) {
            return false;
        }
        if (!checkCell(3, 6, board)) {
            return false;
        }
        if (!checkCell(3, 3, board)) {
            return false;
        }
        if (!checkCell(6, 6, board)) {
            return false;
        }
        if (!checkCell(6, 3, board)) {
            return false;
        }
        return true;
    }
    public boolean checkRow(int i, char[][] board) {
        char[] row = board[i];
        Set<Integer> set = new HashSet<>();
        for (char c: row) {
            if (c == '.') {
                continue;
            }
            if (set.contains((int) c)) {
                return false;
            }
            set.add((int) c);
        }
        return true;
    }

    public boolean checkCol(int j, char[][] board) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            char c = board[i][j];
            if (c == '.') {
                continue;
            }
            if (set.contains((int) c)) {
                return false;
            }
            set.add((int) c);
        }
        return true;
    }

    public boolean checkCell(int row, int col, char[][] board) {
        Set<Integer> set = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (set.contains((int) c)) {
                    return false;
                }
                set.add((int) c);
            }
        }
        return true;
    }
}
