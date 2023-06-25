package algorithm.recent.algorithm.sortandthinking;

import java.util.Arrays;
import java.util.Collections;

public class TakeCard {

  private int solution(int[] nums, int k) {
    int answer = 0;
    int n = nums.length;
    int round = n / 2;

    Integer[] cards = Arrays.stream(nums).boxed().toArray(Integer[]::new);
    Arrays.sort(cards, Collections.reverseOrder());

    Integer[] diff = new Integer[cards.length / 2];

    for (int i = 0; i < round; i++) {
      answer += cards[i * 2 + 1];
      diff[i] = cards[i*2] - cards[i*2+1];
    }

    Arrays.sort(diff, Collections.reverseOrder());

    for (int i = 0; i < k; i++) {
      answer += diff[i];
    }

    return answer;
  }

  public static void main(String[] args) {
    TakeCard main = new TakeCard();
    System.out.println(main.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
    System.out.println(main.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
    System.out.println(main.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
    System.out.println(main.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
    System.out.println(main.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
  }
}
