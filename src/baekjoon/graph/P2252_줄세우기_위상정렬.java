package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P2252_줄세우기_위상정렬 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int N = Integer.parseInt(s[0]);
    int M = Integer.parseInt(s[1]);

    List<List<Integer>> graph = new ArrayList<>();

    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    // 진입차수 배열
    int[] indegree = new int[N+1];

    for (int i = 0; i < M; i++) {
      s = br.readLine().split(" ");
      int start = Integer.parseInt(s[0]);
      int end = Integer.parseInt(s[1]);
      graph.get(start).add(end);
      indegree[end]++;  // 진입차수 배열에 데이터 저장
    }

    // 위상 정렬 실행
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }

    while (!queue.isEmpty()) {
      int current = queue.poll();
      System.out.print(current + " ");
      for (int next: graph.get(current)) {
        indegree[next]--;
        if (indegree[next] == 0) {
          queue.offer(next);
        }
      }
    }
  }
}
