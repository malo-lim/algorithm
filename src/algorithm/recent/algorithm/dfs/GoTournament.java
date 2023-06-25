package algorithm.recent.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

public class GoTournament {

  int n, answer = Integer.MAX_VALUE;
  boolean[] isVisited;

  private void dfs(int level, int start, int[][] cans) {
    if (level == n / 2) {
      List<Integer> teamA = new ArrayList<>();
      List<Integer> teamB = new ArrayList<>();

      for (int i = 0; i < n; i++) {
        if (isVisited[i]) {
          teamA.add(i);
        } else {
          teamB.add(i);
        }
      }

      int sumA = 0, sumB = 0;

      for (int i = 0; i < level; i++) {
        sumA += cans[teamA.get(i)][0];
        sumB += cans[teamB.get(i)][1];
      }

      answer = Math.min(answer, Math.abs(sumA - sumB));

    } else {
      // 조합 공식이므로 그냥 외우기
      for (int i = start; i < n; i++) {
        isVisited[i] = true;
        dfs(level + 1, i + 1, cans);
        isVisited[i] = false;
      }
    }
  }

  private int solution(int[][] cans) {
    n = cans.length;
    isVisited = new boolean[n];

    dfs(0, 0, cans);

    return answer;
  }

  public static void main(String[] args) {
    GoTournament main = new GoTournament();
    System.out.println(main.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
//    System.out.println(main.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
//    System.out.println(main.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33}, {25, 32}, {37, 59}, {33, 47}}));
  }
}
