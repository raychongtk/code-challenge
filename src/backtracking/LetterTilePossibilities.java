package backtracking;

import java.util.Arrays;

/**
 * @author raychong
 */
public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[chars.length];
        return backtrack(visited, chars);
    }

    private int backtrack(boolean[] visited, char[] tiles) {
        int count = 0;
        for (int i = 0; i < tiles.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && tiles[i - 1] == tiles[i] && !visited[i - 1]) continue;
            visited[i] = true;
            count++;
            count += backtrack(visited, tiles);
            visited[i] = false;
        }
        return count;
    }
}
