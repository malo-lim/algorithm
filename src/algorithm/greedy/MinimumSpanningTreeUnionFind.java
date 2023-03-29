package algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MinimumSpanningTreeUnionFind {

  private static class Edge implements Comparable<Edge> {
    int v1, v2, cost;

    public Edge(int v1, int v2, int cost) {
      this.v1 = v1;
      this.v2 = v2;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
      return this.cost - o.cost;
    }
  }

  static int[] unf;

  // 크루스칼 알고리즘 : Union & Find

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

  private static int solution(List<Edge> list, int v) {
    int answer = 0;
    int count = 0;
    Collections.sort(list);

    for (Edge o: list) {
      int findV1 = find(o.v1);
      int findV2 = find(o.v2);

      if (findV1 != findV2) {
        answer += o.cost;
        union(o.v1, o.v2);
        count++;
      }

      if (count == v) {
        break;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    MinimumSpanningTreeUnionFind main = new MinimumSpanningTreeUnionFind();
    Scanner scanner = new Scanner(System.in);
    int v = scanner.nextInt();
    int e = scanner.nextInt();

    unf = new int[v + 1];

    List<Edge> list = new ArrayList<>();

    for (int i=1; i<=v; i++) {
      unf[i] = i;
    }

    for (int i=0; i<e; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int c = scanner.nextInt();

      list.add(new Edge(a, b, c));
    }

    System.out.println(solution(list, v));
  }
}
