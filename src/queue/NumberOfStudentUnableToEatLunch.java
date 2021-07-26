package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author raychong
 */
public class NumberOfStudentUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<>();
        Queue<Integer> sandwichQueue = new LinkedList<>();
        for (int i = 0; i < students.length; i++) {
            studentQueue.offer(students[i]);
            sandwichQueue.offer(sandwiches[i]);
        }

        int unableToEat = 0;
        while (!studentQueue.isEmpty()) {
            int student = studentQueue.poll();
            if (student == sandwichQueue.peek()) {
                sandwichQueue.poll();
                unableToEat = 0;
            } else {
                studentQueue.offer(student);
                unableToEat++;
            }

            if (unableToEat > studentQueue.size()) return studentQueue.size();
        }

        return 0;
    }
}
