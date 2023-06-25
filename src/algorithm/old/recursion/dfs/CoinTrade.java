package algorithm.old.recursion.dfs;

import java.util.*;

public class CoinTrade {
  static int answer = Integer.MAX_VALUE, n, m;

  public void dfs(int level, int sum, Integer[] coin) {
    if (sum > m) {
      return;
    }

    if (level >= answer) {
      return;
    }

    if (sum == m) {
      answer = Math.min(answer, level);
    } else {
      for (int i=0; i<n; i++) {
        dfs(level+1, sum + coin[i], coin);
      }
    }
  }

  public static void main(String[] args) {
    CoinTrade main = new CoinTrade();
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    Integer[] coin = new Integer[n];

    for (int i=0; i<n; i++) {
      coin[i] = scanner.nextInt();
    }

    Arrays.sort(coin, Collections.reverseOrder());

    m = scanner.nextInt();
    main.dfs(0, 0, coin);
    System.out.println(answer);
  }

}
