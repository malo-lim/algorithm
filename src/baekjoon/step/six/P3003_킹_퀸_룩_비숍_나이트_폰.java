package baekjoon.step.six;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P3003_킹_퀸_룩_비숍_나이트_폰 {

  private static final int[] chess = {1, 1, 2, 2, 2, 8};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer token = new StringTokenizer(br.readLine());
    int[] answer = new int[chess.length];

    for (int i = 0; i < chess.length; i++) {
      answer[i] = chess[i] - Integer.parseInt(token.nextToken());
    }

    Arrays.stream(answer)
        .forEach(System.out::println);
  }
}
