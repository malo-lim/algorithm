package algorithm.array;

import java.util.Scanner;

public class TemporaryChief {

  public int solution(int n, int[][] arr) {
    int answer = 0, max = Integer.MIN_VALUE;
    int count = 0;

    for (int i=1; i<=n; i++) {
      count = 0;
      for (int j=1; j<=n; j++) {
        for (int k=1; k<=5; k++) {
          if (arr[i][k] == arr[j][k]) {
            count++;
            break;
          }
        }
      }

      if (count > max) {
        max = count;
        answer = i;
      }

    }

    return answer;
  }

  public static void main(String[] args) {
    TemporaryChief main = new TemporaryChief();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[][] arr = new int[n+1][6];

    for (int i=1; i<n+1; i++) {
      for (int j=1; j<=5; j++) {
        arr[i][j] = scanner.nextInt();
      }
    }

    System.out.println(main.solution(n, arr));

  }
}
