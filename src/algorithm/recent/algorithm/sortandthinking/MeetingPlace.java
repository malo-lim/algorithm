package algorithm.recent.algorithm.sortandthinking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingPlace {

  private int solution(int[][] board) {
    int answer = 0;
    int n = board.length;
    List<Integer> col = new ArrayList<>();
    List<Integer> row = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 1) {
          row.add(i);
          col.add(j);
        }
      }
    }

    col.sort(Comparator.naturalOrder());

    int rowPlace = row.get(row.size() / 2);
    int colPlace = col.get(col.size() / 2);

    for (int x: row) {
      answer += Math.abs(rowPlace - x);
    }

    for (int x: col) {
      answer += Math.abs(colPlace - x);
    }

    return answer;
  }

  public static void main(String[] args) {
    MeetingPlace main = new MeetingPlace();
    System.out.println(main.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
    System.out.println(main.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
    System.out.println(main.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
  }
}
