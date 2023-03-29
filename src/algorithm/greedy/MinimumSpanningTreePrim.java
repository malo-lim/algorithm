package algorithm.greedy;

import java.util.*;

public class MinimumSpanningTreePrim {

  private static class Edge implements Comparable<Edge> {
    int vertex, cost;

    public Edge(int vertex, int cost) {
      this.vertex = vertex;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
      return this.cost - o.cost;
    }
  }

  static boolean[] visit;
  static List<List<Edge>> graph = new ArrayList<>();

  private int solution() {
    int answer = 0;
    Queue<Edge> pQ = new PriorityQueue<>();
    pQ.offer(new Edge(1, 0));

    while (!pQ.isEmpty()) {
      Edge temp = pQ.poll();
      int endVertex = temp.vertex;

      if (!visit[endVertex]) {
        visit[endVertex] = true;
        answer += temp.cost;

        for (Edge o: graph.get(endVertex)) {
          if (!visit[o.vertex]) {
            pQ.offer(new Edge(o.vertex, o.cost));
          }
        }
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    MinimumSpanningTreePrim main = new MinimumSpanningTreePrim();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();

    for (int i=0; i<=n; i++) {
      graph.add(new ArrayList<>());
    }

    visit = new boolean[n + 1];

    for (int i=0; i<m; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int c = scanner.nextInt();

      graph.get(a).add(new Edge(b, c));
      graph.get(b).add(new Edge(a, c));
    }

    System.out.println(main.solution());

  }

}
