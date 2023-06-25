package algorithm.recent.algorithm.datastructure;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class MostUsedMeetingRoom {

  private int solution(int n, int[][] meetings) {
    int answer = 0;
    int[] result = new int[n]; // 회의실당 몇번 사용 했는지 결과 값 저장할 변수

    PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
    TreeSet<Integer> rooms = new TreeSet<>();
    Arrays.sort(meetings, (x, y) -> x[0] - y[0]);

    for (int i = 0; i < n; i++) {
      rooms.add(i);
    }

    for (int[] m: meetings) {
      // 회의실에 들어가있고, 회의실의 끝나는 시간이 다음 시작시간보다 작거나 같으면 회의실 에서 빼주고, 방에 사용할 수 있게 번호를 넣어준디.
      while (!pq.isEmpty() && pq.peek()[0] <= m[0]) {
        rooms.add(pq.poll()[1]); // 회의실을 비우기 위해 루트에서 꺼내서 회의실 번호를 넣어준다.
      }

      // 룸이 비어있다면 룸에 배정하기
      if (!rooms.isEmpty()) {
        int room = rooms.pollFirst();
        result[room]++;
        pq.add(new int[]{m[1], room}); // 끝나는 시간과 방 번호를 넣어준다.
      } else {
        // 룸이 꽉차있다면, 다음 진행
        int[] e = pq.poll(); // 제일 빨리 끝나는 회의를 꺼낸다
        result[e[1]]++; // 그리고 그 방번호의 값을 더해준다.
        pq.add(new int[]{e[0] + (m[1] - m[0]), e[1]}); // 끝나는 시간에 회의가 진행된 시간을 더한다.(이게 끝나는 시간)
      }
    }

    int max = 0;
    for (int i = 0; i < n; i++) {
      // 여러개라면, 번호가 작은 값을 넣어주기 위해 비교한다.
      if (result[i] > max) {
        max = result[i];
        answer = i;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    MostUsedMeetingRoom main = new MostUsedMeetingRoom();
    System.out.println(main.solution(2, new int[][]{{0, 5}, {2, 7}, {4, 5}, {7, 10}, {9, 12}}));
    System.out.println(main.solution(3, new int[][]{{3, 9}, {1, 10}, {5, 8}, {10, 15}, {9, 14}, {12, 14}, {15, 20}}));
    System.out.println(main.solution(3, new int[][]{{1, 30}, {2, 15}, {3, 10}, {4, 12}, {6, 10}}));
    System.out.println(main.solution(4, new int[][]{{3, 20}, {1, 25}, {5, 8}, {10, 15}, {9, 14}, {12, 14},{15, 20}}));
  }
}
