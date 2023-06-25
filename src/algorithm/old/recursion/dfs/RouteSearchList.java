package algorithm.old.recursion.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RouteSearchList {
  static int n, m, answer = 0;
  static List<List<Integer>> graph;
  static boolean[] visit;

  public void dfs(int v) {
    if (v == n) {
      answer++;
    } else {
      for (int next: graph.get(v)) {
        if (!visit[next]) {
          visit[next] = true;
          dfs(next);
          visit[next] = false;
        }
      }
    }
  }

  public static void main(String[] args) {
    RouteSearchList main = new RouteSearchList();
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    m = scanner.nextInt();
    graph = new ArrayList<>();

    for (int i=0; i<=n; i++) {
      graph.add(new ArrayList<>());
    }

    visit = new boolean[n + 1];
    for (int i=0; i<m; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      graph.get(a).add(b);
    }

    visit[1] = true;
    main.dfs(1);
    System.out.println(answer);
  }
}
