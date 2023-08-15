package baekjoon.doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P13023_ABCDE {

  static List<List<Integer>> graph;
  static boolean[] isVisited;
  static boolean isArrived;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    graph = new ArrayList<>();
    isVisited = new boolean[N];

    for (int i = 0; i < N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    for (int i = 0; i < N; i++) {
      dfs(i, 1);

      if (isArrived) {
        break;
      }
    }

    System.out.println(isArrived ? 1 : 0);

  }

  private static void dfs(int num, int depth) {
    if (depth == 5 || isArrived) {
      isArrived = true;
      return;
    }

    isVisited[num] = true;

    for (int i : graph.get(num)) {
      if (!isVisited[i]) {
        dfs(i, depth + 1);
      }
    }

    isVisited[num] = false;
  }
}
