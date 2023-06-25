package algorithm.old.dp;

import java.util.Scanner;

public class LongestIncreasingSubsequence {

  public int solution(int[] arr) {
    int answer = 0;
    int[] dp = new int[arr.length];
    dp[0] = 1;

    for (int i=1; i<arr.length; i++) {
      int max = 0;
      for (int j=i-1; j>=0; j--) {
        if (arr[j] < arr[i] && dp[j] > max) {
          max = dp[j];
        }
      }
      dp[i] = max + 1;
      answer = Math.max(answer, dp[i]);
    }

    return answer;
  }

  public static void main(String[] args) {
    LongestIncreasingSubsequence main = new LongestIncreasingSubsequence();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arr = new int[n];

    for (int i=0; i<n; i++) {
      arr[i] = scanner.nextInt();
    }

    System.out.println(main.solution(arr));
  }
}
