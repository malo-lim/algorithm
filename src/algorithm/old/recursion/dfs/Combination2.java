package algorithm.old.recursion.dfs;

import java.util.Scanner;

public class Combination2 {

  static int[] combination;
  static int n, m;

  private void dfs(int level, int s) {
    if (level == m) {
      for (int x: combination) {
        System.out.print(x + " ");
      }
      System.out.println();
    } else {
      for (int i=s; i<=n; i++) {
        combination[level] = i;
        dfs(level+1, i+1);
      }
    }
  }

  public static void main(String[] args) {
    Combination2 main = new Combination2();
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    m = scanner.nextInt();
    combination = new int[m];

    main.dfs(0,1);
  }
}
