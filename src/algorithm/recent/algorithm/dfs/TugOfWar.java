package algorithm.recent.algorithm.dfs;

import java.util.Stack;

public class TugOfWar {

  int answer;
  Stack<Integer> stack;
  boolean[][] isRelated;
  boolean[] isVisited;

  int LAST = 7;

  private void dfs(int num) {
    if (num == LAST) {
      answer++;
    } else {
      for (int i = 1; i <= LAST; i++) {
        // 이전 사람과 현재 사람이 싫어하는 사람인 경우 진행하지 않고 continue;
        if (!stack.isEmpty() && isRelated[stack.peek()][i]) {
          continue;
        }
        if (!isVisited[i]) {
          isVisited[i] = true;
          stack.push(i);
          dfs(num + 1);
          isVisited[i] = false;
          stack.pop();
        }
      }
    }
  }

  private int solution(int[][] nums) {
    answer = 0;
    stack = new Stack<>();
    isRelated = new boolean[8][8];
    isVisited = new boolean[8];

    for (int[] x: nums) {
      isRelated[x[0]][x[1]] = true;
      isRelated[x[1]][x[0]] = true;
    }

    dfs(0);

    return answer;
  }

  public static void main(String[] args) {
    TugOfWar main = new TugOfWar();
    System.out.println(main.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
//    System.out.println(main.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
//    System.out.println(main.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
//    System.out.println(main.solution(new int[][]{{1 ,7}}));
//    System.out.println(main.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
  }
}
