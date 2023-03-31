package algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;

public class TradeCoin {
  static int n, m;
  static int[] dp;
  private int solution(int[] coins) {
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int i=0; i<n; i++) {
      for (int j=coins[i]; j<=m; j++) {
         dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
      }
    }

    return dp[m];
  }

  public static void main(String[] args) {
    TradeCoin main = new TradeCoin();
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    int[] coins = new int[n];

    for (int i=0; i<n; i++) {
      coins[i] = scanner.nextInt();
    }

    m = scanner.nextInt();
    dp = new int[m + 1];

    System.out.println(main.solution(coins));
  }
}
