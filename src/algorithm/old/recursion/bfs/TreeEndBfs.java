package algorithm.old.recursion.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class TreeEndBfs {

  private static class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
      data = val;
      lt = rt = null;
    }
  }

  Node root;

  public int bfs(Node root) {
    Queue<Node> Q = new LinkedList<>();
    Q.offer(root);
    int level = 0;
    int length = 0;

    while (!Q.isEmpty()) {
      length = Q.size();

      for (int i=0; i<length; i++) {
        Node current = Q.poll();
        if (current.lt == null && current.rt == null) {
          return level;
        }

        if (current.lt != null) {
          Q.offer(current.lt);
        }

        if (current.rt != null) {
          Q.offer(current.rt);
        }
      }

      level++;
    }

    return 0;
  }

  public static void main(String[] args) {
    TreeEndBfs tree = new TreeEndBfs();
    tree.root = new Node(1);
    tree.root.lt = new Node(2);
    tree.root.rt = new Node(3);
    tree.root.lt.lt = new Node(4);
    tree.root.lt.rt = new Node(5);
    System.out.println(tree.bfs(tree.root));
  }

}
