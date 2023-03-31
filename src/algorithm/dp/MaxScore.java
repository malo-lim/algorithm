package algorithm.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxScore {

  private static class Problem {
    int score, time;
    public Problem(int score, int time) {
      this.score = score;
      this.time = time;
    }
  }

  static int n, m;
  static int[] dp;

  private int solution(List<Problem> list) {

    for (Problem p: list) {
      for (int j=m; j>=p.time; j--) {
        dp[j] = Math.max(dp[j], dp[j-p.time] + p.score);
      }
    }

    return dp[m];
  }

  public static void main(String[] args) {
    MaxScore main = new MaxScore();
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    m = scanner.nextInt();
    dp = new int[m + 1];
    List<Problem> list = new ArrayList<>();

    for (int i=0; i<n; i++) {
      int score = scanner.nextInt();
      int time = scanner.nextInt();
      list.add(new Problem(score, time));
    }

    System.out.println(main.solution(list));
  }
}
