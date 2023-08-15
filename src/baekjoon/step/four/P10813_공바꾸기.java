package baekjoon.step.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class P10813_공바꾸기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer token = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(token.nextToken());
    int M = Integer.parseInt(token.nextToken());

    int[] balls = IntStream.range(0, N).map(i -> i + 1).toArray();

    for (int k = 0; k < M; k++) {
      token = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(token.nextToken());
      int j = Integer.parseInt(token.nextToken());

      swap(balls, i, j);
    }

    Arrays.stream(balls)
        .mapToObj(ball -> ball + " ")
        .forEach(System.out::print);

  }

  private static void swap(int[] arr, int start, int end) {
    int temp = arr[start - 1];
    arr[start - 1] = arr[end - 1];
    arr[end - 1] = temp;
  }
}
