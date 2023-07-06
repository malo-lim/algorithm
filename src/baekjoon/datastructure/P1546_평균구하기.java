package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1546_평균구하기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] scores = new int[N];
    StringTokenizer token = new StringTokenizer(br.readLine());
    int max = Integer.MIN_VALUE;
    int sum = 0;

    for (int i = 0; i < N; i++) {
      int score = Integer.parseInt(token.nextToken());
      scores[i] = score;
      sum += score;
      max = Math.max(max, score);
    }

    // 공식 : sum * 100 / max / N
    double result = (double) (sum * 100) / max / N;
    System.out.println(result);
  }
}
