package algorithm.recursion.dfs;

public class SubsetDfs {
  static int n;
  static boolean[] check;

  public void dfs(int l) {
    if (l == n + 1) {
      StringBuilder temp = new StringBuilder();
      for (int i=1; i<=n; i++) {
        if (check[i]) {
          temp.append(i).append(" ");
        }
      }

      if (temp.length() > 0) {
        System.out.println(temp);
      }

    } else {
      check[l] = true;
      dfs(l+1);

      check[l] = false;
      dfs(l+1);
    }
  }

  public static void main(String[] args) {
    SubsetDfs main = new SubsetDfs();
    n = 3;
    check = new boolean[n + 1];
    main.dfs(1);
  }
}
