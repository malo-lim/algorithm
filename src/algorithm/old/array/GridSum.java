package algorithm.old.array;

import java.util.Scanner;

public class GridSum {

  public int solution(int n, int[][] arr) {
    int answer = 0;
    int rowSum, columnSum;

    for (int i=0; i<n; i++) {
      rowSum = columnSum = 0;

      for (int j=0; j<n; j++) {
        rowSum += arr[i][j];
        columnSum += arr[j][i];
      }
      answer = Math.max(answer, rowSum);
      answer = Math.max(answer, columnSum);
    }

    rowSum = columnSum = 0;

    for (int i=0; i<n; i++) {
      rowSum += arr[i][i];
      columnSum += arr[i][n-i-1];

      answer = Math.max(answer, rowSum);
      answer = Math.max(answer, columnSum);
    }

    return answer;
  }


  public static void main(String[] args) {
    GridSum main = new GridSum();
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
