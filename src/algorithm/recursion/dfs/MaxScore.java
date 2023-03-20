package algorithm.recursion.dfs;

import java.util.Scanner;

public class MaxScore {
  static int answer = Integer.MIN_VALUE, n, m;

  public void dfs(int level, int sum, int time, int[] sums, int[] times) {
    if (time > m) {
      return;
    }

    if (level == n) {
      answer = Math.max(answer, sum);
    } else {
      dfs(level + 1, sum + sums[level], time + times[level], sums, times);
      dfs(level + 1, sum, time, sums, times);
    }
  }

  public static void main(String[] args) {
    MaxScore main = new MaxScore();
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    m = scanner.nextInt();

    int[] sums = new int[n];
    int[] times = new int[n];

    for (int i=0; i<n; i++) {
      sums[i] = scanner.nextInt();
      times[i] = scanner.nextInt();
    }

    main.dfs(0, 0, 0, sums, times);
    System.out.println(answer);
  }
}
