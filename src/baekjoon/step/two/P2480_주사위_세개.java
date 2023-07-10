package baekjoon.step.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2480_주사위_세개 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int n1 = Integer.parseInt(s[0]);
    int n2 = Integer.parseInt(s[1]);
    int n3 = Integer.parseInt(s[2]);

    if (n1 == n3 && n2 == n3) {
      System.out.println(10000 + (n1 * 1000));
    } else if (n1 == n2 || n1 == n3) {
      System.out.println(1000 + (n1 * 100));
    } else if (n2 == n3) {
      System.out.println(1000 + (n2 * 100));
    } else {
      System.out.println(Math.max(n1, Math.max(n2, n3)) * 100);
    }
  }
}
