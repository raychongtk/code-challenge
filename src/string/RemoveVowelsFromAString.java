package string;

import java.util.Set;

/**
 * @author raychong
 */
public class RemoveVowelsFromAString {
    public static void main(String[] args) {
        System.out.println(removeVowels("aeiou")); // remove all
        System.out.println(removeVowels("leetcodeisacommunityforcoders")); // ltcdscmmntyfrcdrs
        System.out.println(removeVowels("byte")); // byt
        System.out.println(removeVowels("xyz")); // xyz
    }

    public static String removeVowels(String input) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        var builder = new StringBuilder();
        char[] chars = input.toCharArray();

        for (char c : chars) {
            if (!vowels.contains(c)) builder.append(c);
        }

        return builder.toString();
    }
}
