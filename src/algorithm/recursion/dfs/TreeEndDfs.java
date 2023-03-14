package algorithm.recursion.dfs;

public class TreeEndDfs {

  private static class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
      data = val;
      lt = rt = null;
    }

  }

  Node root;
  public int dfs(int level, Node root) {
    if (root.lt == null && root.rt == null) {
      return level;
    } else {
      return Math.min(dfs(level+1, root.lt), dfs(level+1, root.rt));
    }
  }

  public static void main(String[] args) {
    TreeEndDfs tree = new TreeEndDfs();
    tree.root = new Node(1);
    tree.root.lt = new Node(2);
    tree.root.rt = new Node(3);
    tree.root.lt.lt = new Node(4);
    tree.root.lt.rt = new Node(5);

    System.out.println(tree.dfs(0, tree.root));
  }

}
