package algorithm.recursion.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IslandDfs {

  static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
  static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
  static int answer = 0, n;
  private void dfs(int x, int y, int[][] board) {
    for (int i=0; i<8; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if ((nx >= 0 && nx < n) && (ny >= 0 && ny < n) && board[nx][ny] == 1) {
        board[nx][ny] = 0;
        dfs(nx, ny, board);
      }
    }
  }

  private void solution(int[][] board) {
    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        if (board[i][j] == 1) {
          answer++;
          board[i][j] = 0;
          dfs(i, j, board);
        }
      }
    }
  }

  public static void main(String[] args) {
    IslandDfs main = new IslandDfs();
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
