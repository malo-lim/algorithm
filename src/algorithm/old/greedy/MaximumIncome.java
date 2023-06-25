package algorithm.old.greedy;

import java.util.*;

public class MaximumIncome {

  private static class Lecture implements Comparable<Lecture> {
    int money, day;

    public Lecture(int money, int day) {
      this.money = money;
      this.day = day;
    }

    @Override
    public int compareTo(Lecture o) {
      return o.day - this.day;
    }
  }

  static int n, max = Integer.MIN_VALUE;

  private int solution(List<Lecture> list) {
    int answer = 0;
    Collections.sort(list);
    Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
    int j = 0;

    for (int i = max; i>=1; i--) {
      for (; j<n; j++) {
        if (list.get(j).day < i) {
          break;
        }
        pQ.offer(list.get(j).money);
      }

      if (!pQ.isEmpty()) {
        answer += pQ.poll();
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    MaximumIncome main = new MaximumIncome();
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    List<Lecture> list = new ArrayList<>();

    for (int i=0; i<n; i++) {
      int money = scanner.nextInt();
      int day = scanner.nextInt();

      list.add(new Lecture(money, day));

      if (day > max) {
        max = day;
      }
    }

    System.out.println(main.solution(list));
  }

}
