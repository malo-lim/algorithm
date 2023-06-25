package algorithm.recent.algorithm.simulation;

import java.util.Arrays;

public class Ladder {

  private char[] solution(int n, int[][] ladder) {
    char[] answer = new char[n];
    for (int i=0; i<n; i++) {
      answer[i] = (char) (i + 65);
    }

    for (int[] line: ladder) {
      for (int num: line) {
        char temp = answer[num-1];
        answer[num-1] = answer[num];
        answer[num] = temp;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Ladder main = new Ladder();

    System.out.println(Arrays.toString(main.solution(5, new int[][] {{1,3}, {2,4}, {1,4}})));
    System.out.println(Arrays.toString(main.solution(7, new int[][] {{1,3,5}, {1,3,6}, {2,4}})));

  }
}
