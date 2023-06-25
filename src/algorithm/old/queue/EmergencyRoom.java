package algorithm.old.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EmergencyRoom {

  private static class Person {
    int id;
    int priority;
    public Person(int id, int priority) {
      this.id = id;
      this.priority = priority;
    }
  }

  public int solution(int n, int m, int[] arr) {
    int answer = 1;
    Queue<Person> queue = new LinkedList<>();

    for (int i=0; i<n; i++) {
      queue.offer(new Person(i, arr[i]));
    }

    while (!queue.isEmpty()) {
      Person person = queue.poll();

      for (Person q: queue) {
        if (q.priority > person.priority) {
          queue.offer(person);
          person = null;
          break;
        }
      }

      if (person != null) {
        if (person.id == m) {
          return answer;
        } else {
          answer++;
        }
      }

    }

    return answer;
  }

  public static void main(String[] args) {
    EmergencyRoom main = new EmergencyRoom();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int[] arr = new int[n];

    for (int i=0; i<n; i++) {
      arr[i] = scanner.nextInt();
    }

    System.out.println(main.solution(n, m, arr));
  }
}
