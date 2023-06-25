package algorithm.old.greedy;

import java.util.Scanner;

public class Friend {
  static int[] unf;

  private static int find(int v) {
    if (unf[v] == v) {
      return v;
    } else {
      return unf[v] = find(unf[v]);
    }
  }

  private static void union(int from, int to) {
    int findFrom = find(from);
    int findTo = find(to);

    if (findFrom != findTo) {
      unf[findFrom] = findTo;
    }
  }

  public static void main(String[] args) {
    Friend main = new Friend();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    unf = new int[n + 1];

    for (int i=1; i<=n; i++) {
      unf[i] = i;
    }

    for (int i=1; i<=m; i++) {
      int from = scanner.nextInt();
      int to = scanner.nextInt();
      union(from, to);
    }

    int from = scanner.nextInt();
    int to = scanner.nextInt();

    if (find(from) == find(to)) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }


  }
}
