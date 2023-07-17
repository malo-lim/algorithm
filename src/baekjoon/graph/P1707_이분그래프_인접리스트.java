package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1707_이분그래프_인접리스트 {

  static List<Integer>[] graph;
  static boolean[] visited;
  static int[] checked;
  static boolean isEven;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int K = Integer.parseInt(br.readLine());

    for (int t = 0; t < K; t++) {
      String[] s = br.readLine().split(" ");
      int V = Integer.parseInt(s[0]);
      int E = Integer.parseInt(s[1]);

      graph = new ArrayList[V+1];
      visited = new boolean[V+1];
      checked = new int[V+1];
      isEven = true;

      for (int i = 1; i <= V; i++) {
        graph[i] = new ArrayList<>();
      }

      // 에지에 데이터 저장하기
      // 인접리스트로 구현
      for (int i = 0; i < E; i++) {
        s = br.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        int end = Integer.parseInt(s[1]);
        graph[start].add(end);
        graph[end].add(start);
      }

      // 모든 노드에서 DFS 실행
      for (int i = 1; i <= V; i++) {
        // 이분 그래프 일경우에만 실행
        if (isEven) {
          dfs(i);
        } else {
          break;
        }
      }

      if (isEven) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }

  }

  private static void dfs(int current) {
    // 탐색했다고 true로 변경
    visited[current] = true;

    // 인접 리스트로 받아서 node에서 연결된 모든 노드를 탐색
    for (int next : graph[current]) {
      if (!visited[next]) {
        // 바로 직전에 있는 노드와 다른 집합으로 분류를 해주는 것이 필요.
        checked[next] = (checked[current] + 1) % 2;
        dfs(next);
      } else if (checked[current] == checked[next]) {
        isEven = false;
      }
    }
  }
}
