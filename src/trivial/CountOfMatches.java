package trivial;

/**
 * @author raychong
 */
public class CountOfMatches {
    public static void main(String[] args) {
        System.out.println(numberOfMatches(2));
    }

    public static int numberOfMatches(int n) {
        int teams = n;
        int matches;
        int totalMatches = 1;

        while (teams > 2) {
            if (teams % 2 == 0) {
                matches = teams / 2;
                teams = teams / 2;
            } else {
                matches = (teams - 1) / 2;
                teams = (teams - 1) / 2 + 1;
            }

            totalMatches += matches;
        }

        return totalMatches;
    }
}
