package algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Stall {

  public boolean isPossible(int[] arr, int dist, int c) {
    int count = 1;
    int ep = arr[0];

    for (int i=1; i<arr.length; i++) {
      if (arr[i]-ep >= dist) {
        count++;
        ep = arr[i];
      }
    }

    return count >= c;
  }

  public int solution(int n, int c, int[] arr) {
    Arrays.sort(arr);

    int answer = 0;
    int lt = 1;
    int rt = arr[n-1];
    int mid = 0;

    while (lt<=rt) {
      mid = (lt + rt) / 2;

      if (isPossible(arr, mid, c)) {
        answer = mid;
        lt = mid + 1;
      } else {
        rt = mid - 1;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Stall main = new Stall();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int c = scanner.nextInt();
    int[] arr = new int[n];

    for (int i=0; i<n; i++) {
      arr[i] = scanner.nextInt();
    }

    System.out.println(main.solution(n, c, arr));
  }
}
