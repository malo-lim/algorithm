package algorithm.old.recursion.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IslandBfs {

  private static class Point {
    int x, y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
  static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
  static int answer = 0, n;

  private void bfs(int x, int y, int[][] board) {
    Queue<Point> Q = new LinkedList<>();
    Q.offer(new Point(x, y));

    while (!Q.isEmpty()) {
      Point current = Q.poll();
      for (int i=0; i<8; i++) {
        int nx = current.x + dx[i];
        int ny = current.y + dy[i];

        if ((nx >= 0 && nx < n) && (ny >= 0 && ny < n) && board[nx][ny] == 1) {
          board[nx][ny] = 0;
          Q.offer(new Point(nx, ny));
        }
      }
    }
  }

  private void solution(int[][] board) {
    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        if (board[i][j] == 1) {
          answer++;
          board[i][j] = 0;
          bfs(i, j, board);
        }
      }
    }
  }

  public static void main(String[] args) {
    IslandBfs main = new IslandBfs();
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();

    int[][] arr = new int[n][n];

    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        arr[i][j] = scanner.nextInt();
      }
    }

    main.solution(arr);
    System.out.println(answer);

  }

}
