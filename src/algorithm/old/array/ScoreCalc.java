package algorithm.old.array;

import java.util.Scanner;

public class ScoreCalc {

  public int solution(int n, int[] arr) {
    int sum = 0;
    int count = 0;

    for (int i=0; i<n; i++) {
      if (arr[i] == 1) {
        count++;
        sum += count;
      } else {
        count = 0;
      }
    }

    return sum;
  }

  public static void main(String[] args) {
    ScoreCalc main = new ScoreCalc();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arr = new int[n];

    for (int i=0; i<n; i++) {
      arr[i] = scanner.nextInt();
    }

    System.out.println(main.solution(n, arr));
  }
}
