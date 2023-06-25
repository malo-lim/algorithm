package algorithm.old.dp;

import java.util.Scanner;

public class UpStair {
  static int[] dp;

  private int solution(int n) {
    dp[1] = 1;
    dp[2] = 2;

    for (int i=3; i<=n; i++) {
      dp[i] = dp[i-2] + dp[i-1];
    }

    return dp[n];
  }

  public static void main(String[] args) {
    UpStair main = new UpStair();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    dp = new int[n + 1];

    System.out.println(main.solution(n));
  }
}
