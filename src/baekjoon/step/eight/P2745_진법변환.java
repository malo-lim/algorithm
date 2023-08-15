package baekjoon.step.eight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2745_진법변환 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");

    String N = s[0];
    int B = Integer.parseInt(s[1]);
    int length = N.length();

    int total = 0; // 합계
    int pow = 1; // 제곱근 값

    for (int i = length - 1; i >= 0; i--) {
      char c = s[0].charAt(i);

      if (c >= 'A' && c <= 'Z') {
        total += (c - 'A' + 10) * pow; // A - Z 인경우 문자 A를 배면 A가 0이 나오므로, +10을 해준다.
      } else {
        total += (c - '0') * pow; // 그대로 숫자를 곱한다.
      }

      pow *= B;

    }

    System.out.println(total);

  }
}
