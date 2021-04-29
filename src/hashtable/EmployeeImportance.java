package hashtable;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author raychong
 */
public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();

        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(id);

        int totalImportance = 0;
        while (!deque.isEmpty()) {
            Employee employee = map.get(deque.pop());
            totalImportance += employee.importance;
            deque.addAll(employee.subordinates);
        }

        return totalImportance;
    }

    public static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
