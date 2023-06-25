package algorithm.old.recursion.dfs;

import java.util.Scanner;

public class RouteSearchDfs {

  static int n, m, answer = 0;
  static boolean[] visit;
  static int[][] graph;

  public void dfs(int v) {
    if (v == n) {
      answer++;
    } else {
      for (int i=1; i<=n; i++) {
        if (graph[v][i] == 1 && !visit[i]) {
          visit[i] = true;
          dfs(i);
          visit[i] = false;
        }
      }
    }
  }

  public static void main(String[] args) {
    RouteSearchDfs main = new RouteSearchDfs();
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    m = scanner.nextInt();

    graph = new int[n+1][n+1];
    visit = new boolean[n+1];

    for (int i=0; i<m; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      graph[a][b] = 1;
    }

    visit[1] = true;
    main.dfs(1);
    System.out.println(answer);
  }
}
