package algorithm.recent.algorithm.sortandthinking;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfRooms {

  private int solution(int[][] meetings) {
    int answer = 0;
    int n = meetings.length;
    List<int[]> list = new ArrayList<>();

    for (int[] x: meetings) {
      list.add(new int[]{x[0], 1});
      list.add(new int[]{x[1], 2});
    }

    list.sort((x, y) -> x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]);
    int count = 0;

    for (int[] x: list) {
      if (x[1] == 1) {
        count++;
      } else {
        count--;
      }
      answer = Math.max(answer, count);
    }

    return answer;
  }

  public static void main(String[] args) {
    MinimumNumberOfRooms main = new MinimumNumberOfRooms();
    System.out.println(main.solution(new int[][]{{0, 10}, {12, 25}, {5, 15}, {2, 5}}));
    System.out.println(main.solution(new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
    System.out.println(main.solution(new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    System.out.println(main.solution(new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
  }
}
