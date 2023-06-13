package recent.algorithm.simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxBitonicSequence {
  private int solution(int[] nums) {
    int answer = 0;
    List<Integer> peaks = new ArrayList<>();

    for (int i=1; i<nums.length-1; i++) {
      if (nums[i] > nums[i+1] && nums[i] > nums[i-1]) {
        peaks.add(i);
      }
    }

    for (int peak: peaks) {
      int count = 1;
      int left = peak, right = peak;

      while(left-1 >= 0 && nums[left] > nums[left-1]) {
        count++;
        left--;
      }
      while(right+1 < nums.length && nums[right] > nums[right+1]) {
        count++;
        right++;
      }

      answer = Math.max(answer, count);
    }

    return answer;
  }

  public static void main(String[] args) {
    MaxBitonicSequence main = new MaxBitonicSequence();
    Scanner scanner = new Scanner(System.in);

    System.out.println(main.solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1}));
    System.out.println(main.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
    System.out.println(main.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
    System.out.println(main.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
  }
}
