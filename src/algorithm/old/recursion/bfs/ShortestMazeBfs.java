package algorithm.old.recursion.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestMazeBfs {

  private static class Point {
    int x, y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {-1, 1, 0, 0};
  static int[][] distance, board;

  private void bfs(int x, int y) {
    Queue<Point> Q = new LinkedList<>();
    Q.offer(new Point(x, y));
    board[x][y] = 1;

    while (!Q.isEmpty()) {
      Point current = Q.poll();

      for (int i=0; i<4; i++) {
        int nx = current.x + dx[i];
        int ny = current.y + dy[i];

        if ((nx >= 1 && nx <= 7) && (ny >= 1 && ny <= 7) && board[nx][ny] == 0) {
          board[nx][ny] = 1;
          Q.offer(new Point(nx, ny));
          distance[nx][ny] = distance[current.x][current.y] + 1;
        }
      }
    }

  }

  public static void main(String[] args) {
    ShortestMazeBfs main = new ShortestMazeBfs();
    Scanner scanner = new Scanner(System.in);
    board = new int[8][8];
    distance = new int[8][8];

    for (int i=1; i<=7; i++) {
      for (int j=1; j<=7; j++) {
        board[i][j] = scanner.nextInt();
      }
    }

    main.bfs(1, 1);

    if (distance[7][7] == 0) {
      System.out.println(-1);
    } else {
      System.out.println(distance[7][7]);
    }

  }
}
