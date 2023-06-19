package baekjoon.search.dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P11724_연결요소의개수 {

  static boolean[] visited;
  static List<List<Integer>> graph = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer token = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(token.nextToken());
    int M = Integer.parseInt(token.nextToken());

    // 각 값들 초기화
    visited = new boolean[N + 1];
    int count = 0;

    // 0값이 주어지지 않기 때문에 리스트를 1번부터 초기화 한다.
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    // 그래프에 인접 목록을 add
    for (int i = 0 ; i < M; i++) {
      token = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(token.nextToken());
      int v = Integer.parseInt(token.nextToken());

      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    // 방문하기
    for (int i = 1; i <= N; i++) {
      // 방문하지 않은 노드가 있으면 방문하고, count 증가
      if (!visited[i]) {
        count++;
        dfs(i);
      }
    }

    // 출력
    bw.write(Integer.toString(count));
    bw.close();

  }

  private static void dfs(int v) {
    // 만약에 방문했다면 종료
    if (visited[v]) {
      return;
    }
    // 방문한 상태로 변경하고, v간선 탐색
    visited[v] = true;
    for (int vv: graph.get(v)) {
      if (!visited[vv]) {
        dfs(vv);
      }
    }
  }

}
