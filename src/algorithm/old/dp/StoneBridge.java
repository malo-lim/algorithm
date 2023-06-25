package algorithm.old.dp;

import java.util.Scanner;

public class StoneBridge {
  static int[] dp;

  private int solution(int n) {
    dp[1] = 1;
    dp[2] = 2;

    for (int i=3; i<=n+1; i++) {
      dp[i] = dp[i-2] + dp[i-1];
    }

    return dp[n+1];
  }

  public static void main(String[] args) {
    StoneBridge main = new StoneBridge();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    dp = new int[n + 2];

    System.out.println(main.solution(n));
  }
}
