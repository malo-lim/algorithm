package recent.algorithm.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class TileJumping {

  private int solution(int[] nums) {
    int level = 0;
    int n = nums.length;
    boolean[] isVisited = new boolean[n];

    Queue<Integer> Q = new LinkedList<>();
    Q.offer(0);

    while (!Q.isEmpty()) {
      int size = Q.size();

      for (int i = 0; i < size; i++) {
        int x = Q.poll(); // Q의 첫번째 즉, nums의 길이만큼..

        for (int j = 1; j <= nums[x]; j++) {
          int nx = x + j;

          // nx의 길이가 전체 길이 -1 이랑 동일하다면 level + 1 을 리턴해준다.
          // 레벨은 0부터 시작이므로...
          if (nx == n - 1) {
            return level + 1;
          }

          // 방문하기
          if (nx < n && !isVisited[nx]) {
            isVisited[nx] = true;
            Q.offer(nx);
          }
        }
      }
      level++;
    }
    return -1;
  }

  public static void main(String[] args) {
    TileJumping main = new TileJumping();
    System.out.println(main.solution(new int[]{2, 2, 1, 2, 1, 1}));
    System.out.println(main.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
    System.out.println(main.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
    System.out.println(main.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
    System.out.println(main.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
  }
}
