package dfs;

/**
 * @author raychong
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int len, int row, int column) {
        if (words.length == len) return true;
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) return false;
        if (words[len] != board[row][column]) return false;
        if (board[row][column] == '0') return false;

        char c = board[row][column];
        board[row][column] = '0';
        boolean exist = dfs(board, words, len + 1, row + 1, column) ||
                dfs(board, words, len + 1, row, column + 1) ||
                dfs(board, words, len + 1, row - 1, column) ||
                dfs(board, words, len + 1, row, column - 1);
        board[row][column] = c;
        return exist;
    }
}
