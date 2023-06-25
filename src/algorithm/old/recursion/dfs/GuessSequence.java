package algorithm.old.recursion.dfs;

import java.util.Scanner;

public class GuessSequence {
  static int[] combination, permutation;
  static boolean[] visited;
  static int n, f;
  boolean flag = false;
  int[][] dy = new int[35][35];

  private int combination(int n, int r) {
    if (dy[n][r] > 0) {
      return dy[n][r];
    }

    if (n == r || r == 0) {
      return 1;
    } else {
      return dy[n][r] = combination(n-1, r-1) + combination(n-1, r);
    }
  }

  private void dfs(int level, int sum) {
    if (flag) {
      return;
    }

    if (level == n) {
      if (sum == f) {
        for (int x: permutation) {
          System.out.print(x + " ");
        }
        flag = true;
      }
    } else {
      for (int i=1; i<=n; i++) {
        if (!visited[i]) {
          visited[i] = true;
          permutation[level] = i;
          dfs(level + 1, sum + (permutation[level] * combination[level]));
          visited[i] = false;
        }
      }
    }
  }

  public static void main(String[] args) {
    GuessSequence main = new GuessSequence();
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    f = scanner.nextInt();
    combination = new int[n];
    permutation = new int[n];
    visited = new boolean[n+1];

    for (int i=0; i<n; i++) {
      combination[i] = main.combination(n-1, i);
    }

    main.dfs(0, 0);

  }

}
