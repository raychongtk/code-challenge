package array;

/**
 * @author raychong
 */
public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxDuration = releaseTimes[0];
        char maxDurationKey = keysPressed.charAt(0);

        for (int i = 1; i < releaseTimes.length; i++) {
            int currentDuration = releaseTimes[i] - releaseTimes[i - 1];
            if (currentDuration < maxDuration) continue;

            char currentKey = keysPressed.charAt(i);
            if (currentDuration > maxDuration) {
                maxDuration = currentDuration;
                maxDurationKey = currentKey;
            } else if (currentKey > maxDurationKey) {
                maxDurationKey = currentKey;
            }
        }

        return maxDurationKey;
    }
}
