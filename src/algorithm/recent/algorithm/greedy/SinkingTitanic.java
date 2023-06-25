package algorithm.recent.algorithm.greedy;

import java.util.Arrays;

public class SinkingTitanic {

  private int solution(int[] nums, int m) {
    int answer = 0;
    int n = nums.length;

    Arrays.sort(nums);

    int left = 0;
    int right = n - 1;

    while (left <= right) {
      if (nums[left] + nums[right] <= m) {
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
    SinkingTitanic main = new SinkingTitanic();
    System.out.println(main.solution(new int[]{90, 50, 70, 100, 60}, 140));
    System.out.println(main.solution(new int[]{86, 95, 107, 67, 38, 49, 116, 22, 78, 53}, 150));
    System.out.println(main.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
  }
}
