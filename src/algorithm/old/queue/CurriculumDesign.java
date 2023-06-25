package algorithm.old.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CurriculumDesign {

    public String solution1(String required, String subject) {
        Queue<Character> queue = new LinkedList<>();

        for (char c: required.toCharArray()) {
            queue.offer(c);
        }

        for (char c: subject.toCharArray()) {
            if (queue.peek() == c) {
                queue.poll();
            }

            if (queue.size() == 0) {
                return "YES";
            }
        }

        return "NO";
    }

    public String solution2(String required, String subject) {
        Queue<Character> queue = new LinkedList<>();

        for (char c: required.toCharArray()) {
            queue.offer(c);
        }

        for (char c: subject.toCharArray()) {
            if (queue.contains(c)) {
                if (queue.poll() != c) {
                    return "NO";
                }
            }
        }

        if (!queue.isEmpty()) {
            return "NO";
        }

        return "YES";
    }

    public static void main(String[] args) {
        CurriculumDesign main = new CurriculumDesign();
        Scanner scanner = new Scanner(System.in);
        String required = scanner.next();
        String subject = scanner.next();

        System.out.println(main.solution1(required, subject));
        System.out.println(main.solution2(required, subject));
    }
}
