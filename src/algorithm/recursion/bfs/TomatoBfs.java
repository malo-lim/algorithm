package algorithm.recursion.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TomatoBfs {

  static int[][] board, distance;
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {-1, 1, 0, 0};
  static int row, column;
  static Queue<Point> Q = new LinkedList<>();

  private static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  private void bfs() {
    while (!Q.isEmpty()) {
      Point current = Q.poll();

      for (int i=0; i<4; i++) {
        int nx = current.x + dx[i];
        int ny = current.y + dy[i];

        if ((nx >= 0 && nx < row) && (ny >= 0 && ny < column) && board[nx][ny] == 0) {
          board[nx][ny] = 1;
          Q.offer(new Point(nx, ny));
          distance[nx][ny] = distance[current.x][current.y] + 1;
        }
      }
    }

  }

  public static void main(String[] args) {
    TomatoBfs main = new TomatoBfs();
    Scanner scanner = new Scanner(System.in);
    column = scanner.nextInt();
    row = scanner.nextInt();

    board = new int[row][column];
    distance = new int[row][column];

    for (int i=0; i<row; i++) {
      for (int j=0; j<column; j++) {
        board[i][j] = scanner.nextInt();
        if (board[i][j] == 1) {
          Q.offer(new Point(i, j));
        }
      }
    }

    main.bfs();
    boolean hasAnswer = true;
    int answer = Integer.MIN_VALUE;

    for (int i=0; i<row; i++) {
      for (int j=0; j<column; j++) {
        if (board[i][j] == 0) {
          hasAnswer = false;
          break;
        }
      }
    }

    if (hasAnswer) {
      for (int i=0; i<row; i++) {
        for (int j=0; j<column; j++) {
          answer = Math.max(answer, distance[i][j]);
        }
      }
      System.out.println(answer);
    } else {
      System.out.println(-1);
    }

  }

}
