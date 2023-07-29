package baekjoon.doit;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class P2164_카드2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    Queue<Integer> Q = new LinkedList<>();

    for (int i = 1; i <= N; i++) {
      Q.offer(i);
    }

    while (Q.size() != 1) {
      Q.poll(); // 맨 윗장 버리기
      Q.offer(Q.poll());
    }

    bw.write(Integer.toString(Q.poll()));
    bw.close();
  }
}
