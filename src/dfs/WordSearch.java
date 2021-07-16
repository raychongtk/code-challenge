package dfs;

/**
 * @author raychong
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, "", i, j)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, String current, int row, int column) {
        if (word.equals(current)) return true;
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) return false;
        if (current.length() > word.length()) return false;
        if (board[row][column] == '0') return false;

        char c = board[row][column];
        current += c;
        board[row][column] = '0';
        boolean exist = dfs(board, word, current, row + 1, column) ||
                dfs(board, word, current, row, column + 1) ||
                dfs(board, word, current, row - 1, column) ||
                dfs(board, word, current, row, column - 1);
        board[row][column] = c;
        return exist;
    }
}
