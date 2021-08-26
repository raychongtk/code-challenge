package string;

/**
 * @author raychong
 */
public class DefangingIpAddress {
    public String defangIPaddr(String address) {
        var builder = new StringBuilder();
        char[] ipAddress = address.toCharArray();

        for (char part : ipAddress) {
            if (part == '.') {
                builder.append("[.]");
            } else {
                builder.append(part);
            }
        }

        return builder.toString();
    }
}
