package baekjoon.doit;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178_미로탐색 {

  static final int[] dx = {0, 0, -1, 1};
  static final int[] dy = {1, -1, 0, 0};
  static boolean[][] visited;
  static int[][] graph;
  static int N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    graph = new int[N][M];
    visited = new boolean[N][M];

    for (int y = 0; y < N; y++) {
      st = new StringTokenizer(br.readLine());
      String line = st.nextToken();
      for (int x = 0; x < M; x++) {
        graph[y][x] = line.charAt(x) - '0';
      }
    }

    br.close();

    bfs(0, 0);
    bw.write(String.valueOf(graph[N - 1][M - 1]));
    bw.close();

  }

  private static void bfs(int i, int j) {
    Queue<int[]> Q = new LinkedList<>();
    Q.offer(new int[]{i, j});
    visited[i][j] = true;

    while (!Q.isEmpty()) {
      int[] now = Q.poll();
      for (int k = 0; k < 4; k++) {
        int ny = now[0] + dy[k];
        int nx = now[1] + dx[k];

        if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
          if (graph[ny][nx] != 0 && !visited[ny][nx]) {
            visited[ny][nx] = true;
            graph[ny][nx] = graph[now[0]][now[1]] + 1;
            Q.add(new int[]{ny, nx});
          }
        }
      }
    }

  }
}
