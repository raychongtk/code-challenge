import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author raychong
 */
public class ValidSudoku {
    // https://leetcode.com/problems/valid-sudoku/
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> columns = new ArrayList<>();
        List<Set<Character>> partialSudoku = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            columns.add(new HashSet<>());
            partialSudoku.add(new HashSet<>());
        }

        int rowBucket = 0;
        for (int i = 0; i < 9; i++) {
            int columnBucket = 0;
            for (int j = 0; j < 9; j++) {
                if (i != 0 && j == 0 && i % 3 == 0) rowBucket += 3;
                if (j != 0 && j % 3 == 0) columnBucket++;
                if (board[i][j] == '.') continue;
                if (!rows.get(i).add(board[i][j]) || !columns.get(j).add(board[i][j])) return false;
                if (!partialSudoku.get(rowBucket + columnBucket).add(board[i][j])) return false;
            }
        }

        return true;
    }
}
