package baekjoon.doit;

import java.io.*;
import java.util.*;

public class P1167_트리의지름 {

  static List<List<Edge>> graph = new ArrayList<>();
  static boolean[] visited;
  static int[] distance;

  private static final class Edge {
    int edge;
    int value;

    public Edge(int edge, int value) {
      this.edge = edge;
      this.value = value;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int S = Integer.parseInt(st.nextToken());

      while (true) {
        int edge = Integer.parseInt(st.nextToken());

        if (edge == -1) {
          break;
        }

        int value = Integer.parseInt(st.nextToken());
        graph.get(S).add(new Edge(edge, value));
      }
    }

    distance = new int[N + 1];
    visited = new boolean[N + 1];

    bfs(1);
    int max = 1;

    for (int i = 2; i <= N; i++) {
      if (distance[max] < distance[i]) {
        max = i;
      }
    }

    distance = new int[N + 1];
    visited = new boolean[N + 1];
    bfs(max);

    Arrays.sort(distance);
    bw.write(String.valueOf(distance[N]));
    bw.close();
    br.close();
  }

  private static void bfs(int index) {
    Queue<Integer> Q = new LinkedList<>();
    Q.add(index);
    visited[index] = true;

    while (!Q.isEmpty()) {
      int now = Q.poll();
      for (Edge i : graph.get(now)) {
        int e = i.edge;
        int v = i.value;

        if (!visited[e]) {
          visited[e] = true;
          Q.add(e);
          distance[e] = distance[now] + v;
        }
      }
    }
  }
}
