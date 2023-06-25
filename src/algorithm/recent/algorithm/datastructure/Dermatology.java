package algorithm.recent.algorithm.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class Dermatology {

  private int getTime(String time) {
    String[] split = time.split(":");
    int hour = Integer.parseInt(split[0]);
    int minute = Integer.parseInt(split[1]);

    return (hour * 60) + minute;
  }

  private int solution(int[] laser, String[] enter) {
    int answer = 0;
    int n = enter.length;
    int[][] inList = new int[n][2];
    int endTIme = 1200;
    Queue<Integer> queue = new LinkedList<>();

    // inList에 값 세팅한다.
    for (int i=0; i<n; i++) {
      String[] split = enter[i].split(" ");
      int enterTime = getTime(split[0]);
      int laserType = Integer.parseInt(split[1]);

      inList[i][0] = enterTime;
      inList[i][1] = laserType;
    }

    // 먼저 처음 온 고객은 레이저실로 바로 들어간다.
    queue.offer(inList[0][1]);
    int finishTime = inList[0][0]; // 종료 시간을 현재 들어간 시간으로 만들어준다.
    int pos = 1; // 다음 고객을 알기 위하여 잡은 인덱스값

    // 처음 종료 시간부터 20:00시까지 (endTime 즉, 종료시간) 반복
    for (int time=finishTime; time<=endTIme; time++) {
      // 다음 고객이 있으면서, 다음 고객이 도착한 경우
      if (pos < n && time == inList[pos][0]) {
        // 레이저실에도 없고, finishTime보다도 Time이 크다면(즉, 다음 사람의 시간으로 건너 뛰기 위해..)
        if (queue.isEmpty() && time > finishTime) {
          finishTime = time;
        }

        queue.offer(inList[pos][1]);
        pos++;
      }

      // 이전 사람이 레이저가 끝난 경우 finishTime을 증가시키기 위해..
      if (time == finishTime && !queue.isEmpty()) {
        finishTime += laser[queue.poll()];
      }
      answer = Math.max(answer, queue.size());
    }

    return answer;
  }

  public static void main(String[] args) {
    Dermatology main = new Dermatology();
    System.out.println(main.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
    System.out.println(main.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
    System.out.println(main.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
  }
}
