package algorithm.old.recursion.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LevelSearch {

  Node root;

  private static class Node {
    int data;
    Node lt, rt;
    public Node(int val) {
      data = val;
      lt = rt = null;
    }
  }

  public void bfs(Node root) {
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    int level = 0;
    int len = 0;

    while (!queue.isEmpty()) {
      len = queue.size();
      System.out.print(level + " : ");
      for (int i=0; i<len; i++) {
        Node current = queue.poll();
        System.out.print(current.data + " ");

        if (current.lt != null) {
          queue.offer(current.lt);
        }

        if (current.rt != null) {
          queue.offer(current.rt);
        }

      }

      level++;
      System.out.println();
    }

  }

  public static void main(String[] args) {
    LevelSearch tree = new LevelSearch();
    tree.root = new Node(1);
    tree.root.lt = new Node(2);
    tree.root.rt = new Node(3);
    tree.root.lt.lt = new Node(4);
    tree.root.lt.rt = new Node(5);
    tree.root.rt.lt = new Node(6);
    tree.root.rt.rt = new Node(7);
    tree.bfs(tree.root);
  }
}
