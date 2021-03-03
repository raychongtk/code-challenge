import java.util.List;

/**
 * @author raychong
 */
public class CountItemsMatchingARule {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = key(ruleKey);
        int count = 0;

        for (List<String> item : items) {
            if (ruleValue.equals(item.get(index))) {
                count++;
            }
        }

        return count;
    }

    private int key(String ruleKey) {
        if ("type".equals(ruleKey)) {
            return 0;
        } else if ("color".equals(ruleKey)) {
            return 1;
        } else if ("name".equals(ruleKey)) {
            return 2;
        } else {
            return -1;
        }
    }
}
