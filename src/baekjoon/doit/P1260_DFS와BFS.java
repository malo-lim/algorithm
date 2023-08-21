package baekjoon.doit;

import java.io.*;
import java.util.*;

public class P1260_DFS와BFS {

  static List<List<Integer>> graph = new ArrayList<>();
  static boolean[] visited;
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    // N + 1만큼 초기화
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    // 그래프 간선 입력
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    // 각 리스트 별로 오름차순
    for (int i = 1; i <= N; i++) {
      Collections.sort(graph.get(i));
    }

    visited = new boolean[N + 1];
    dfs(V);
    bw.newLine();
    bw.flush();

    visited = new boolean[N + 1];
    bfs(V);
    bw.close();

  }

  private static void bfs(int node) throws IOException {
    Queue<Integer> Q = new LinkedList<>();
    Q.offer(node);
    visited[node] = true;

    while (!Q.isEmpty()) {
      int now = Q.poll();

      bw.write(now + " ");
      for (int i : graph.get(now)) {
        if (!visited[i]) {
          visited[i] = true;
          Q.offer(i);
        }
      }
    }
  }

  private static void dfs(int node) throws IOException {
    bw.write(node + " ");

    visited[node] = true;
    for (int i : graph.get(node)) {
      if (!visited[i]) {
        dfs(i);
      }
    }
  }
}
