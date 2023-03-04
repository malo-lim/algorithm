package algorithm.recursion.dfs;

public class Factorial {

  public int dfs(int n) {
    if (n == 1) {
      return 1;
    } else {
      return n * dfs(n-1);
    }
  }

  public static void main(String[] args) {
    Factorial main = new Factorial();
    System.out.println(main.dfs(5));
  }
}
