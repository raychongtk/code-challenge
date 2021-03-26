import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author raychong
 */
public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> table = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String cpdomain : cpdomains) {
            int spaceIndex = cpdomain.indexOf(' ');
            int count = Integer.parseInt(cpdomain.substring(0, spaceIndex));
            String domain = cpdomain.substring(spaceIndex + 1);
            table.put(domain, table.getOrDefault(domain, 0) + count);

            int firstDotIndex = domain.indexOf('.');
            int lastDotIndex = domain.lastIndexOf('.');
            String key = domain.substring(firstDotIndex + 1);
            table.put(key, table.getOrDefault(key, 0) + count);

            if (firstDotIndex != lastDotIndex) {
                key = domain.substring(lastDotIndex + 1);
                table.put(key, table.getOrDefault(key, 0) + count);
            }
        }

        for (Map.Entry<String, Integer> entry : table.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }

        return result;
    }
}
