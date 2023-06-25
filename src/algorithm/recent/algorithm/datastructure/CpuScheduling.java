package algorithm.recent.algorithm.datastructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class CpuScheduling {

  private int[] solution(int[][] tasks) {
    int n = tasks.length;
    int[] answer = new int[n];
    LinkedList<int[]> programs = new LinkedList<>();

    for (int i=0; i<n; i++) {
      programs.add(new int[]{tasks[i][0], tasks[i][1], i});
    }

    // 호출 시간을 기준으로 정렬
    programs.sort((x, y) -> x[0] - y[0]);
    PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x == y ? x[1] - y[1] : x[0] - y[0]);

    int finishTime = 0, idx = 0;

    while (!programs.isEmpty() || !queue.isEmpty()) {
      if (queue.isEmpty()) {
        finishTime = Math.max(finishTime, programs.peek()[0]);
      }

      while (!programs.isEmpty() && programs.peek()[0] <= finishTime) {
        int[] x = programs.pollFirst();
        queue.add(new int[]{x[1], x[2]});
      }

      int[] ex = queue.poll();
      finishTime += ex[0];
      answer[idx++] = ex[1];
    }


    return answer;
  }

  public static void main(String[] args) {
    CpuScheduling main = new CpuScheduling();
    System.out.println(Arrays.toString(main.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
  }
}
