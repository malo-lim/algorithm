package baekjoon.datastructure;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class P11286_절댓값힙 {
  public static void main(String[] args) throws IOException {
    // Lambda 써서 절댓값 기준으로 정렬하기
    PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> {

      int first = Math.abs(o1);
      int second = Math.abs(o2);

      // 절댓값이 작은 경우 음수 우선
      if (first == second) {
        return o1 > o2 ? 1 : -1;
      }

      return first - second; // 절댓값 작은 데이터 우선
    }));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      int x = Integer.parseInt(br.readLine());

      if (x != 0) {
        queue.offer(x);
      } else {
        if (!queue.isEmpty()) {
          bw.write(""+queue.poll());
          bw.newLine();
        } else {
          bw.write("0");
          bw.newLine();
        }
      }
    }
    bw.close();
  }
}
