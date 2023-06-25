package algorithm.recent.algorithm.greedy;

import java.util.Arrays;

public class ShortestTimeBloom {

  private int solution(int[] planTime, int[] growTime) {
    int answer = 0;
    int n = planTime.length;
    int[][] time = new int[n][2];

    // 심는 시간이랑 자라는 시간을 먼저 time 배열에 각각 넣어준다.
    for (int i = 0; i < n; i++) {
      time[i][0] = planTime[i];
      time[i][1] = growTime[i];
    }

    // 자라는 시간을 기준으로 내림차순 정렬한다.
    Arrays.sort(time, (x, y) -> y[1] - x[1]);
    int start = 0, end = 0;

    /*
    밑의 코드가 그리디 핵심 알고리즘이다.
     1. greedy 인데, 마지막 값에 시작 + 심는 시간 + 자라는 시간을 더해준다.
     2. answer 에 end 값과 비교를 해서 더 큰값을 answer 에 넣어준다.
     3. start 에 심는 시간을 더해준다.
     */
    for (int[] x: time) {
      end = start + x[0] + x[1];
      answer = Math.max(answer, end);
      start += x[0];
    }

    return answer;
  }

  public static void main(String[] args) {
    ShortestTimeBloom main = new ShortestTimeBloom();
    System.out.println(main.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
    System.out.println(main.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
    System.out.println(main.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
    System.out.println(main.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
    System.out.println(main.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
  }
}
