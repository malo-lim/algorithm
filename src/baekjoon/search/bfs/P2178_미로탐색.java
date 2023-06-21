package baekjoon.search.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178_미로탐색 {
  // 필요한 값 초기화
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {-1, 1, 0, 0};
  static int[][] graph;
  static boolean[][] visited;
  static int N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer token = new StringTokenizer(br.readLine());

    N = Integer.parseInt(token.nextToken());
    M = Integer.parseInt(token.nextToken());

    graph = new int[N][M];
    visited = new boolean[N][M];

    // 그래프에 할당
    for (int i = 0 ; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < M; j++) {
        graph[i][j] = s.charAt(j) - '0';
      }
    }

    // bfs 탐색 시작
    bfs(0, 0);

    bw.write(Integer.toString(graph[N-1][M-1]));
    bw.close();
  }

  private static void bfs(int i, int j) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{i, j});
    visited[i][j] = true;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      // 상하좌우 탐색
      for (int k = 0; k < 4; k++) {
        int nx = now[0] + dx[k];
        int ny = now[1] + dy[k];

        // 탐색 조건
        // 0보단 커야하고, N, M보단 작아야 탐색이 가능하므로 이러한 조건이 들어감
        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
          // 방문하지 않은곳과 이동할 수 있는 곳만 탐색
          if (graph[nx][ny] != 0 && !visited[nx][ny]) {
            visited[nx][ny] = true;
            graph[nx][ny] = graph[now[0]][now[1]] + 1;
            queue.offer(new int[]{nx, ny}); // 다음곳 탐색할 위치를 넣어준다.
          }
        }
      }
    }
  }
}
