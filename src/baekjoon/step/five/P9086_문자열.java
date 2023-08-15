package baekjoon.step.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9086_문자열 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      String s = br.readLine();
      System.out.printf("%c%c%n", s.charAt(0), s.charAt(s.length() - 1));
    }

  }
}
