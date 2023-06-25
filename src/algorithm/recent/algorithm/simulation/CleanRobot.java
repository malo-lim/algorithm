package algorithm.recent.algorithm.simulation;

import java.util.Scanner;

public class CleanRobot {

  private int[] solution(int[][] board, int k, int n) {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int[] answer = {0, 0};
    int d = 1;
    int x = 0, y = 0;

    while (k != 0) {
      k--;
      int nx = x + dx[d];
      int ny = y + dy[d];

      if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
        d = (d + 1) % 4;
        continue;
      }

      x = nx;
      y = ny;
    }
    answer[0] = x;
    answer[1] = y;

    return answer;
  }

  public static void main(String[] args) {
    CleanRobot main = new CleanRobot();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int k = scanner.nextInt();

    int[][] board = new int[n][n];

    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        board[i][j] = scanner.nextInt();
      }
    }
    /*
      5
      10
      0 0 0 0 0
      0 1 1 0 0
      0 0 0 0 0
      1 0 1 0 1
      0 0 0 0 0
     */
    int[] answer = main.solution(board, k, n);
    System.out.println(answer[0] + ", " + answer[1]);

  }
}
