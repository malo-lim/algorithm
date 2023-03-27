package algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Wedding {
  private static class Time implements Comparable<Time> {
    int time;
    char status;

    public Time(int time, char status) {
      this.time = time;
      this.status = status;
    }

    @Override
    public int compareTo(Time o) {
      if (this.time == o.time) {
        return this.status - o.status;
      } else {
        return this.time - o.time;
      }
    }
  }

  private int solution(List<Time> list) {
    int answer = 0;
    int count = 0;
    Collections.sort(list);

    for (Time t: list) {
      if (t.status == 's') {
        count++;
      } else {
        count--;
      }
      answer = Math.max(answer, count);
    }

    return answer;
  }

  public static void main(String[] args) {
    Wedding main = new Wedding();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<Time> list = new ArrayList<>();


    for (int i=0; i<n; i++) {
      int startTime = scanner.nextInt();
      int endTime = scanner.nextInt();

      list.add(new Time(startTime, 's'));
      list.add(new Time(endTime, 'e'));
    }

    System.out.println(main.solution(list));
  }

}
