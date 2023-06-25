package algorithm.recent.algorithm.sortandthinking;

import java.util.Arrays;

public class BinarySort {

  private int getOneCount(int num) {
    int count = 0;

    while (num > 0) {
      count += num % 2;
      num /= 2;
    }

    return count;
  }

  private int[] solution(int[] nums) {
    int n = nums.length;
    int[] answer = new int[n];
    int[][] result = new int[n][2];
    int count = 0;

    for (int i = 0; i < n; i++) {
      count = getOneCount(nums[i]);
      result[i][0] = nums[i];
      result[i][1] = count;
    }

    Arrays.sort(result, (x, y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);

    for (int i = 0; i < n; i++) {
      answer[i] = result[i][0];
    }

    return answer;
  }

  public static void main(String[] args) {
    BinarySort main = new BinarySort();
    System.out.println(Arrays.toString(main.solution(new int[]{5, 6, 7, 8, 9})));
    System.out.println(Arrays.toString(main.solution(new int[]{5, 4, 3, 2, 1})));
    System.out.println(Arrays.toString(main.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
  }
}
