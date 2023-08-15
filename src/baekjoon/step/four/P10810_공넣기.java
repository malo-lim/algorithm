package baekjoon.step.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10810_공넣기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer token = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(token.nextToken());
    int M = Integer.parseInt(token.nextToken());

    int[] balls = new int[N];

    for (int t = 0; t < M; t++) {
      token = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(token.nextToken());
      int j = Integer.parseInt(token.nextToken());
      int k = Integer.parseInt(token.nextToken());

      for (int l = i - 1; l < j; l++) {
        balls[l] = k;
      }
    }

    for (int ball : balls) {
      System.out.print(ball + " ");
    }

  }
}
