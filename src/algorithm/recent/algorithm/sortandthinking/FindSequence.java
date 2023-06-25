package algorithm.recent.algorithm.sortandthinking;

import java.util.*;

public class FindSequence {

  private int[] solution(int[] nums) {
    int[] answer = new int[nums.length / 2];
    Map<Integer, Integer> map = new HashMap<>();

    for (int num: nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    Arrays.sort(nums);
    int idx = 0;

    for (int key: nums) {
      if (map.get(key) == 0) {
        continue;
      }

      answer[idx] = key;
      idx++;

      map.put(key, map.get(key) - 1);
      map.put(key*2, map.get(key*2) - 1);
    }

    return answer;
  }
  public static void main(String[] args) {
    FindSequence main = new FindSequence();
    System.out.println(Arrays.toString(main.solution(new int[]{1, 10, 2, 3, 5, 6})));
    System.out.println(Arrays.toString(main.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
    System.out.println(Arrays.toString(main.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
  }
}
