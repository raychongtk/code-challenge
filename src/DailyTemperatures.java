import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author raychong
 */
public class DailyTemperatures {
    // For example, given the list of temperatures
    // T = [73, 74, 75, 71, 69, 72, 76, 73],
    // your output should be [1, 1, 4, 2, 1, 1, 0, 0].
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Deque<Integer> temperatures = new ArrayDeque<>();
        Deque<Integer> temperaturePositions = new ArrayDeque<>();

        for (int i = 0; i < T.length; i++) {
            while (!temperatures.isEmpty() && temperatures.peek() < T[i]) {
                temperatures.pop();
                int index = temperaturePositions.pop();

                result[index] = i - index;
            }
            temperatures.push(T[i]);
            temperaturePositions.push(i);
        }

        return result;
    }
}
