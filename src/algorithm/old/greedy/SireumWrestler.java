package algorithm.old.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SireumWrestler {

  private static class Body implements Comparable<Body> {
    int height, weight;

    public Body(int height, int weight) {
      this.height = height;
      this.weight = weight;
    }

    @Override
    public int compareTo(Body o) {
      return o.height - this.height;
    }
  }

  private int solution(List<Body> list, int n) {
    int answer = 0;
    int max = Integer.MIN_VALUE;
    Collections.sort(list);

    for (Body body: list) {
      if (body.weight > max) {
        answer++;
        max = body.weight;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    SireumWrestler main = new SireumWrestler();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<Body> list = new ArrayList<>();

    for (int i=0; i<n; i++) {
      int height = scanner.nextInt();
      int weight = scanner.nextInt();

      list.add(new Body(height, weight));
    }

    System.out.println(main.solution(list, n));

  }
}
