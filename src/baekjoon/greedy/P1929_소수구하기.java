package baekjoon.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class P1929_소수구하기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer token = new StringTokenizer(br.readLine());

    int M = Integer.parseInt(token.nextToken());
    int N = Integer.parseInt(token.nextToken());

    boolean[] prime = new boolean[N + 1];

    StringBuilder sb = new StringBuilder();

    // 에라토스테네스의 체로 푼다.
    for (int i = 2; i <= N; i++) {
      // 소수면 continue
      if (prime[i]) {
        continue;
      }

      // i가 M보다 크면 무조건 소수
      if (i >= M) {
        sb.append(i).append('\n');
      }

      // 에라토스테네스의 체
      // i가 2면, j는 4, 왜냐하면 2는 소수기 때문, 그리고 j는 i(2)씩 증가
      for (int j = i+i; j <= N; j = j+i) {
        prime[j] = true;
      }
    }

    bw.write(sb.toString());
    bw.close();
  }
}
