package baekjoon.step.nine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2501_약수구하기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] s = br.readLine().split(" ");
    int N = Integer.parseInt(s[0]);
    int K = Integer.parseInt(s[1]);

    int count = 0;  // 약수 번째 저장할 수
    int result = 0; // 값을 저장할 변수

    for (int i = 1; i <= N; i++) {
      if (N % i == 0) {
        count++;
      }

      if (count == K) {
        result = i;
        break;
      }
    }

    System.out.println(result);

  }
}
