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
            int index = cpdomain.indexOf(' ');
            int count = Integer.parseInt(cpdomain.substring(0, index));
            String domain = cpdomain.substring(index + 1);
            table.put(domain, table.getOrDefault(domain, 0) + count);

            int firstIndex = domain.indexOf('.');
            int lastIndex = domain.lastIndexOf('.');
            String key = domain.substring(firstIndex + 1);
            table.put(key, table.getOrDefault(key, 0) + count);

            if (firstIndex != lastIndex) {
                key = domain.substring(lastIndex + 1);
                table.put(key, table.getOrDefault(key, 0) + count);
            }
        }

        for (Map.Entry<String, Integer> entry : table.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }

        return result;
    }
}
