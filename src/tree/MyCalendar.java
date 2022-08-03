package tree;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {
    private final TreeMap<Integer, Integer> events;

    public MyCalendar() {
        events = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> floorEntry = events.floorEntry(start);
        Map.Entry<Integer, Integer> ceilingEntry = events.ceilingEntry(start);

        if (floorEntry != null && floorEntry.getValue() > start) {
            return false;
        }

        if (ceilingEntry != null && ceilingEntry.getKey() < end) {
            return false;
        }

        events.put(start, end);

        return true;
    }
}
