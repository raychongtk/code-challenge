import java.util.HashMap;
import java.util.Map;

/**
 * @author raychong
 */
public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode head = root;
        for (char c : word.toCharArray()) {
            TrieNode trieNode = head.children.get(c);
            if (trieNode == null) {
                trieNode = new TrieNode();
                head.children.put(c, trieNode);
            }
            head = trieNode;
        }
        head.isCompleteWord = true;
    }

    public boolean search(String word) {
        TrieNode head = root;
        for (char c : word.toCharArray()) {
            TrieNode trieNode = head.children.get(c);
            if (trieNode == null) return false;
            head = trieNode;
        }
        return head.isCompleteWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode head = root;
        for (char c : prefix.toCharArray()) {
            TrieNode trieNode = head.children.get(c);
            if (trieNode == null) return false;
            head = trieNode;
        }
        return true;
    }

    public static class TrieNode {
        private final Map<Character, TrieNode> children = new HashMap<>();
        private boolean isCompleteWord;
    }
}
