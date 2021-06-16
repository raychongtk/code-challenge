package string;

/**
 * @author raychong
 */
public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int vertical = 0;
        int horizontal = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'R') {
                horizontal++;
            } else if (c == 'L') {
                horizontal--;
            } else if (c == 'U') {
                vertical++;
            } else if (c == 'D') {
                vertical--;
            }
        }

        return vertical == 0 && horizontal == 0;
    }
}
