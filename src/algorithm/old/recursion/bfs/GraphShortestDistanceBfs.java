package algorithm.old.recursion.bfs;

import java.util.*;

public class GraphShortestDistanceBfs {

  static int n, m = 0;
  static boolean[] visit;
  static List<List<Integer>> graph;
  static int[] distance;

  public void bfs(int v) {
    Queue<Integer> Q = new LinkedList<>();
    visit[v] = true;
    distance[v] = 0;
    Q.offer(v);

    while (!Q.isEmpty()) {
      int curVertex = Q.poll();

      for (int next: graph.get(curVertex)) {
        if (!visit[next]) {
          visit[next] = true;
          Q.offer(next);
          distance[next] = distance[curVertex] + 1;
        }
      }
    }


  }

  public static void main(String[] args) {
    GraphShortestDistanceBfs main = new GraphShortestDistanceBfs();
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    m = scanner.nextInt();
    graph = new ArrayList<>();

    for (int i=0; i<=n; i++) {
      graph.add(new ArrayList<>());
    }

    visit = new boolean[n + 1];
    distance = new int[n + 1];

    for (int i=0; i<m; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      graph.get(a).add(b);
    }

    main.bfs(1);

    for (int i=2; i<=n; i++) {
      System.out.println(i + " : " + distance[i]);
    }

  }
}
