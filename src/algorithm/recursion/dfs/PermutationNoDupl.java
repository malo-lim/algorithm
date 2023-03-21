package algorithm.recursion.dfs;

import java.util.Scanner;

public class PermutationNoDupl {

  static int[] pm, arr;
  static boolean[] visit;
  static int n, m;

  public void dfs(int level) {
    if (level == m) {
      for (int x: pm) {
        System.out.print(x + " ");
      }
      System.out.println();
    } else {
      for (int i=0; i<n; i++) {
        if (!visit[i]) {
          visit[i] = true;
          pm[level] = arr[i];
          dfs(level+1);
          visit[i] = false;
        }
      }
    }
  }

  public static void main(String[] args) {
    PermutationNoDupl main = new PermutationNoDupl();
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    m = scanner.nextInt();
    arr = new int[n];

    for (int i=0; i<n; i++) {
      arr[i] = scanner.nextInt();
    }

    visit = new boolean[n];
    pm = new int[m];
    main.dfs(0);
  }

}
