package algorithm.old.recursion.dfs;

import java.util.Scanner;

public class BoardDog {

  static int answer = Integer.MIN_VALUE, n, c;

  public void dfs(int level, int sum, int[] arr) {

    if (sum > c) {
      return;
    }

    if (level == n) {
      answer = Math.max(answer, sum);
    } else {
      dfs(level+1, sum + arr[level], arr);
      dfs(level+1, sum, arr);
    }
  }

  public static void main(String[] args) {
    BoardDog main = new BoardDog();
    Scanner scanner = new Scanner(System.in);
    c = scanner.nextInt();
    n = scanner.nextInt();

    int[] arr = new int[n];

    for (int i=0; i<n; i++) {
      arr[i] = scanner.nextInt();
    }

    main.dfs(0, 0, arr);
    System.out.println(answer);
  }

}
