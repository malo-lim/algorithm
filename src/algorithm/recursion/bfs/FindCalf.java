package algorithm.recursion.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindCalf {

  int answer = 0;
  int[] dis = {1, -1, 5};
  int[] check;
  Queue<Integer> Q = new LinkedList<>();

  public int bfs(int s, int e) {
    int length = 0;
    check = new int[10001];
    check[s] = 1;

    Q.offer(s);
    int level = 0;

    while(!Q.isEmpty()) {
      length = Q.size(); // level에 있는 개수들
      for (int i=0; i<length; i++) {
        int x = Q.poll();
        for (int j=0; j<3; j++) {
          int nx = x + dis[j];

          if (nx == e) {
            return level + 1;
          }

          if (nx >= 1 && nx <= 10000 && check[nx] == 0) {
            check[nx] = 1;
            Q.offer(nx);
          }
        }
      }
      level++;
    }

    return 0;

  }

  public static void main(String[] args) {
    FindCalf main = new FindCalf();
    Scanner scanner = new Scanner(System.in);
    int s = scanner.nextInt();
    int e = scanner.nextInt();

    System.out.println(main.bfs(s, e));

  }

}
