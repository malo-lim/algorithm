package algorithm.old.recursion.dfs;

import java.util.Scanner;

public class Combination {

  int[][] dy = new int[34][34];

  private int dfs(int n, int r) {
    if (dy[n][r] > 0) {
      return dy[n][r];
    }

    if (n == r || r == 0) {
      return 1;
    } else {
      return dy[n][r] = dfs(n-1, r-1) + dfs(n-1, r);
    }
  }

  public static void main(String[] args) {
    Combination main = new Combination();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int r = scanner.nextInt();

    System.out.println(main.dfs(n, r));
  }

}
