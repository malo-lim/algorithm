package algorithm.old.greedy;

import java.util.*;

public class Dijkstra {

  private static class Edge implements Comparable<Edge> {
    int vertex, cost;

    public Edge(int vertex, int cost) {
      this.vertex = vertex;
      this.cost = cost;
    }

    // 최소 거리이기 때문에 오름차순을 만든다.
    @Override
    public int compareTo(Edge o) {
      return this.cost - o.cost;
    }
  }

  static int n, m;
  static List<List<Edge>> graph;
  static int[] dis;

  private void solution(int v) {
    Queue<Edge> pQ = new PriorityQueue<>();
    pQ.offer(new Edge(v, 0));

    dis[v] = 0;

    while (!pQ.isEmpty()) {
      Edge temp = pQ.poll();
      int nowVertex = temp.vertex;
      int nowCost = temp.cost;

      if (nowCost > dis[nowVertex]) {
        continue;
      }

      for (Edge object: graph.get(nowVertex)) {
        if (dis[object.vertex] > object.cost + nowCost) {
          dis[object.vertex] = object.cost + nowCost;
          pQ.offer(new Edge(object.vertex, object.cost + nowCost));
        }
      }
    }

  }

  public static void main(String[] args) {
    Dijkstra main = new Dijkstra();
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    m = scanner.nextInt();

    graph = new ArrayList<>();

    for (int i=0; i<=n; i++) {
      graph.add(new ArrayList<>());
    }

    dis = new int[n + 1];
    Arrays.fill(dis, Integer.MAX_VALUE);

    for (int i=0; i<m; i++) {
      int from = scanner.nextInt();
      int to = scanner.nextInt();
      int cost = scanner.nextInt();

      graph.get(from).add(new Edge(to, cost));
    }

    main.solution(1);

    // 출력
    for (int i=2; i<=n; i++) {
      if (dis[i] != Integer.MAX_VALUE) {
        System.out.println(i + " : " + dis[i]);
      } else {
        System.out.println(i + " : impossible");
      }
    }
  }
}
