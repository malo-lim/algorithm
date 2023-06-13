package recent.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Sprinkler {

  private int solution(int n, int[] nums) {
    int answer = 0;

    // 1. nums의 시작 범위와 끝 범위를 계산한다.
    int[][] line = new int[n+1][2];
    for (int i = 0; i <= n; i++) {
      line[i][0] = Math.max(0, i - nums[i]); // 물 뿌리는 시작 범위
      line[i][1] = Math.min(n, i + nums[i]); // 물 뿌리는 끝 범위
    }

    // 2. 시작 범위를 기준으로 오름차순 정렬한다.
    Arrays.sort(line, Comparator.comparingInt(x -> x[0]));

    // 3. line의 범위까지 계산하기 위해 사용
    int start = 0, end = 0, i = 0;
    int lineLength = line.length;

    while (i < lineLength) {

      // 4. line[i][0]의 값이 start보다 작거나 같으면 end를 가장 큰값으로 증가시킨다.
      while (i < lineLength && line[i][0] <= start) {
        end = Math.max(line[i][1], end);
        i++;
      }

      answer++;

      // 5. end와 n이 같다면 다 한것이므로 answer를 리턴
      if (end == n) {
        return answer;
      }

      // 6. start와 end가 같다면 모든 잔디 밭에 물을 줄 수 없으므로 -1 리턴
      if (start == end) {
        return -1;
      }

      // 7. start 를 end 값으로 바꿔준다.
      start = end;
    }

    return answer;
  }

  public static void main(String[] args) {
    Sprinkler main = new Sprinkler();
    System.out.println(main.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
    System.out.println(main.solution(4, new int[]{1, 2, 2, 0, 0}));
    System.out.println(main.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
    System.out.println(main.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
  }
}
