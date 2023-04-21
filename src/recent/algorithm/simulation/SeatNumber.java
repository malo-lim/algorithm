package recent.algorithm.simulation;

import java.util.Scanner;

public class SeatNumber {

  private int[] solution(int c, int r, int k) {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int[] answer = new int[2];

    if ((c * r) < k) {
      return answer;
    }

    int[][] seat = new int[c][r];
    int x = 0, y = 0, i = 1;
    int count = 1;

    while (count < k) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx < 0 || nx >= c || ny >= r || ny < 0 || seat[nx][ny] == 1) {
        i = (i + 1) % 4;
        continue;
      }
      seat[x][y] = 1;
      count++;
      x = nx;
      y = ny;
    }

    answer = new int[]{x + 1, y + 1};
    return answer;
  }

  public static void main(String[] args) {
    SeatNumber main = new SeatNumber();
    Scanner scanner = new Scanner(System.in);
    int c = scanner.nextInt();
    int r = scanner.nextInt();
    int k = scanner.nextInt();

    int[] answer = main.solution(c, r, k);
    System.out.println(answer[0] + ", " + answer[1]);

  }
}
