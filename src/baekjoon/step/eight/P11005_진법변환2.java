package baekjoon.step.eight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11005_진법변환2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");

    int N = Integer.parseInt(s[0]);
    int B = Integer.parseInt(s[1]);

    StringBuilder result = new StringBuilder();

    while (N != 0) {
      int tmp = N % B;

      if (tmp >= 10 && tmp <= 35) {
        result.append((char) ((N % B) + 'A' - 10));
      } else {
        result.append((char) ((N % B) + '0'));
      }

      N = N / B;
    }

    // 첫번째 값 부터 집어 넣었으므로, reverse 해주어야 한다.
    System.out.println(result.reverse().toString());

  }
}
