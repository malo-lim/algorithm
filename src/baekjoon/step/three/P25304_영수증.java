package baekjoon.step.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P25304_영수증 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int X = Integer.parseInt(br.readLine());
    int N = Integer.parseInt(br.readLine());
    int total = 0;

    for (int i = 0; i < N; i++) {
      String[] s = br.readLine().split(" ");
      int price = Integer.parseInt(s[0]);
      int count = Integer.parseInt(s[1]);

      total += (price * count);
    }

    System.out.println(total == X ? "Yes" : "No");
  }
}
