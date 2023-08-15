package baekjoon.step.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class P10811_바구니뒤집기 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer token = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(token.nextToken());
    int M = Integer.parseInt(token.nextToken());

    int[] arr = IntStream.range(0, N).map(i -> i + 1).toArray();

    for (int t = 0; t < M; t++) {
      token = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(token.nextToken()) - 1;
      int j = Integer.parseInt(token.nextToken()) - 1;

      while (i < j) {
        int temp = arr[i];
        arr[i++] = arr[j];
        arr[j--] = temp;
      }
    }

    Arrays.stream(arr)
        .mapToObj(i -> i + " ")
        .forEach(System.out::print);
  }

}