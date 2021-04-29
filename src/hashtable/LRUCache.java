package hashtable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author raychong
 */
public class LRUCache {
    private final int capacity;
    private final LinkedList<Integer> lruList;
    private final Map<Integer, Integer> cacheMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        lruList = new LinkedList<>();
    }

    public int get(int key) {
        Integer value = cacheMap.get(key);
        if (value == null) return -1;
        lruList.removeFirstOccurrence(key);
        lruList.addFirst(key);
        return value;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            lruList.removeFirstOccurrence(key);
        } else if (cacheMap.size() == capacity) {
            Integer removedKey = lruList.removeLast();
            cacheMap.remove(removedKey);
        }
        cacheMap.put(key, value);
        lruList.addFirst(key);
    }
}
