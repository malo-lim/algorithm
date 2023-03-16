package algorithm.recursion.dfs;

import java.util.Scanner;

public class SubsetEqualSum {

  static String answer = "NO";
  static int n, total = 0;
  boolean noRequired = false;

  public void dfs(int level, int sum, int[] arr) {
    if (noRequired) {
      return;
    }

    if (sum > total/2) {
      return;
    }

    if (level == n) {
      if ((total - sum) == sum) {
        answer = "YES";
        noRequired = true;
      }
    } else {
      dfs(level+1, sum + arr[level], arr);
      dfs(level+1, sum, arr);
    }
  }

  public static void main(String[] args) {
    SubsetEqualSum main = new SubsetEqualSum();
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    int[] arr = new int[n];

    for (int i=0; i<n; i++) {
      arr[i] = scanner.nextInt();
      total += arr[i];
    }

    main.dfs(0, 0, arr);
    System.out.println(answer);
  }
}
