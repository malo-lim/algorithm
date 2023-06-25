package algorithm.old.recursion.dfs;

public class Fibonacci {
  static int[] fibo;
  public int dfs(int n) {
    if (fibo[n] > 0) {
      return fibo[n];
    }

    if (n == 1) {
      return fibo[n] = 1;
    } else if (n == 2) {
      return fibo[n] = 1;
    } else {
      return fibo[n] = dfs(n-2) + dfs(n-1);
    }
  }

  public static void main(String[] args) {
    Fibonacci main = new Fibonacci();
    int n = 45;
    fibo = new int[n+1];
    main.dfs(n);
    for (int x: fibo) {
      System.out.print(x + " ");
    }
  }
}
