package algorithm.old.recursion.dfs;

public class BinaryDfs {

  public void dfs(int n) {
    if (n == 0) {
      return;
    } else {
      dfs(n / 2);
      System.out.print(n % 2);
    }
  }

  public static void main(String[] args) {
    BinaryDfs main = new BinaryDfs();
    main.dfs(11);
  }
}
