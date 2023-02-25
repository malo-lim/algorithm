package algorithm.array;

import java.util.Scanner;

public class Peak {

  /*
     // 상 하 좌 우 (보통 말하는..)
     int[] dx = {-1, 1, 0, 0};
     int[] dy = {0, 0, -1, 1};

     // 상 우 하 좌 (시계방향)
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
     */

  // 상 하 좌 우
  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, -1, 1};

  public int solution(int n, int[][] arr) {
    int answer = 0;
    int nx, ny;
    boolean isPeak;

    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        isPeak = true;

        for (int k=0; k<4; k++) {
          nx = i + dx[k];
          ny = j + dy[k];

          if ((nx>=0 && nx<n) && (ny>=0 && ny<n) && arr[nx][ny]>=arr[i][j]) {
            isPeak = false;
            break;
          }
        }

        if (isPeak) {
          answer++;
        }
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Peak main = new Peak();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[][] arr = new int[n][n];

    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        arr[i][j] = scanner.nextInt();
      }
    }

    System.out.println(main.solution(n, arr));

  }
}
