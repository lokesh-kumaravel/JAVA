public class nQueens {
    public static void main(String[] args) {
        int n = 4;  // Example input
        solveNQueens(n);
    }
    public static void solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        char[][] result = solve(0, board);
        if (result != null) {
            printBoard(result);
        } else {
            System.out.println("No solution found");
        }
    }
    public static char[][] solve(int row, char[][] board) {
        if (row == board.length) {
            return copyBoard(board);
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                char[][] result = solve(row + 1, board);
                if (result != null) {
                    return result;
                }
                board[row][col] = '.'; // backtrack
            }
        }
        return null;
    }
    public static boolean isSafe(char[][] board, int row, int col) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static char[][] copyBoard(char[][] board) {
        int n = board.length;
        char[][] newBoard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }

    public static void printBoard(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}