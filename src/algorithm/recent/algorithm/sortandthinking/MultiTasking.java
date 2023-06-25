package algorithm.recent.algorithm.sortandthinking;

import java.util.Arrays;

public class MultiTasking {

  private int solution(int[] tasks, int k) {
    int n = tasks.length;
    int[] taskQ = new int[n + 1];

    System.arraycopy(tasks, 0, taskQ, 1, n);
    Arrays.sort(taskQ);

    int rest = tasks.length;

    for (int i = 1; i < taskQ.length; i++) {
      long time = ((long) rest * (taskQ[i] - taskQ[i - 1])); // 1사이클은 rest 만큼이기 때문에 rest를 곱해주는것

      if (time > k) {
        long idx = k % rest;
        int count = 0;

        for (int j = 0; j < n; j++) {
          if (tasks[j] >= taskQ[i]) {
            if (count == idx) {
              return j + 1;
            }
            count++;
          }
        }
      } else {
        k -= time;
        rest--;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    MultiTasking main = new MultiTasking();
    System.out.println(main.solution(new int[]{1, 2, 3}, 5));
    System.out.println(main.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
    System.out.println(main.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
  }
}
