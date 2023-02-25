package algorithm.twopointer;

import java.util.Scanner;

public class MaxLengthContinuousSubsequence {

  public int solution(int n, int k, int[] arr) {
    int answer = 0, count = 0, lt = 0;

    for (int rt=0; rt<n; rt++) {
      if (arr[rt] == 0) {
        count++;
      }
      while (count > k) {
        if (arr[lt] == 0) {
          count--;
        }
        lt++;
      }
      answer = Math.max(answer, rt-lt+1);
    }
    return answer;
  }

  public static void main(String[] args) {
    MaxLengthContinuousSubsequence main = new MaxLengthContinuousSubsequence();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int k = scanner.nextInt();
    int[] arr = new int[n];

    for (int i=0; i<n; i++) {
      arr[i] = scanner.nextInt();
    }


    System.out.println(main.solution(n, k, arr));
  }
}
