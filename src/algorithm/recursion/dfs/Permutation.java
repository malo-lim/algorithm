package algorithm.recursion.dfs;

import java.util.Scanner;

public class Permutation {
  static int[] pm;
  static int n, m;

  public void dfs(int level) {
    if (level == m) {
      for (int x: pm) {
        System.out.print(x + " ");
      }
      System.out.println();
    } else {
      for (int i=1; i<=n; i++) {
        pm[level] = i;
        dfs(level + 1);
      }
    }
  }

  public static void main(String[] args) {
    Permutation main = new Permutation();
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    m = scanner.nextInt();
    pm = new int[m];

    main.dfs(0);
  }
}
