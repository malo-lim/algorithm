package algorithm.recent.algorithm.greedy;

import java.util.Arrays;

public class NumberOfMoves {

  private int solution(int[] nums) {
    int answer = 0;
    int MAX_WEIGHT = 5;

    Arrays.sort(nums);

    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      if (nums[left] + nums[right] <= MAX_WEIGHT) {
        answer++;
        left++;
        right--;
      } else {
        answer++;
        right--;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    NumberOfMoves main = new NumberOfMoves();
    System.out.println(main.solution(new int[]{2, 5, 3, 4, 2, 3}));
    System.out.println(main.solution(new int[]{2, 3, 4, 5}));
    System.out.println(main.solution(new int[]{3, 3, 3, 3, 3}));
  }
}
