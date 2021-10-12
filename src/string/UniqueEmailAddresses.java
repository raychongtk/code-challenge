package string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author raychong
 */
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            var builder = new StringBuilder();
            boolean atSign = false;
            boolean plusSign = false;
            for (char c : email.toCharArray()) {
                if (c == '.' && !atSign) continue;
                if (c == '@') atSign = true;
                if (c == '+') plusSign = true;
                if (plusSign && !atSign) continue;

                builder.append(c);
            }
            set.add(builder.toString());
        }

        return set.size();
    }
}
