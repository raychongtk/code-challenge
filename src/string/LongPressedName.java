package string;

/**
 * @author raychong
 */
public class LongPressedName {
    public static void main(String[] args) {
        System.out.println(isLongPressedName("pyplrz", "ppyypllr"));
    }

    // Input: name = "alex", typed = "aaleex"
    // Output: true
    public static boolean isLongPressedName(String name, String typed) {
        int typedLength = typed.length();
        int originLength = name.length();
        if (typedLength < originLength) return false;

        int originLeft = 0;
        int typedLeft = 0;
        char previous = '\0';
        boolean end = false;

        while (typedLeft < typedLength) {
            char originCurrentLeft = name.charAt(originLeft);
            char typedCurrentLeft = typed.charAt(typedLeft);

            if (originCurrentLeft == typedCurrentLeft) {
                typedLeft++;
                if (originLeft < originLength - 1) {
                    previous = originCurrentLeft;
                    originLeft++;
                } else {
                    end = true;
                }
            } else if (!end && originLeft > 0 && previous == typedCurrentLeft) {
                typedLeft++;
            } else {
                return false;
            }
        }

        return end;
    }
}
