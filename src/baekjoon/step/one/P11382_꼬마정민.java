package baekjoon.step.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11382_꼬마정민 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    long total = Long.parseLong(s[0]) + Long.parseLong(s[1]) + Long.parseLong(s[2]);

    System.out.println(total);
  }
}
