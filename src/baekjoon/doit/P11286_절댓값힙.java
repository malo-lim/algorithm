package baekjoon.doit;

import java.io.*;
import java.util.PriorityQueue;

public class P11286_절댓값힙 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> Q = new PriorityQueue<>((a, b) -> {
      int first = Math.abs(a);
      int second = Math.abs(b);

      if (first == second) {
        return (a > b) ? 1 : -1;
      } else {
       return first - second;
      }
    });

    for (int i = 0; i < N; i++) {
      int n = Integer.parseInt(br.readLine());
      if (n == 0) {
        if (Q.isEmpty()) {
          bw.write("0\n");
        } else {
          bw.write(Integer.toString(Q.poll()));
          bw.newLine();
        }
      } else {
        Q.offer(n);
      }
    }
    bw.close();
  }
}
