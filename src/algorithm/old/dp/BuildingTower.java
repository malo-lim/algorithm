package algorithm.old.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BuildingTower {

  private static class Brick implements Comparable<Brick> {
    int area, high, weight;
    public Brick(int area, int high, int weight) {
      this.area = area;
      this.high = high;
      this.weight = weight;
    }

    @Override
    public int compareTo(Brick o) {
      return o.area - this.area;
    }
  }

  private int solution(int n, List<Brick> list) {
    int answer = 0;
    int[] dp = new int[n];
    Collections.sort(list);
    dp[0] = list.get(0).high;
    answer = dp[0];

    for (int i=1; i<n; i++) {
      int maxHigh = 0;
      for (int j=i-1; j>=0; j--) {
        if (list.get(j).weight > list.get(i).weight && dp[j] > maxHigh) {
          maxHigh = dp[j];
         }
      }
      dp[i] = maxHigh + list.get(i).high;
      answer = Math.max(answer, dp[i]);
    }

    return answer;
  }

  public static void main(String[] args) {
    BuildingTower main = new BuildingTower();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<Brick> list = new ArrayList<>();

    for (int i=0; i<n; i++) {
      int area = scanner.nextInt();
      int high = scanner.nextInt();
      int weight = scanner.nextInt();

      list.add(new Brick(area, high, weight));
    }

    System.out.println(main.solution(n, list));
  }
}
