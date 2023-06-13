package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940_주몽 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    StringTokenizer token = new StringTokenizer(br.readLine());

    int[] arr = new int[N];
    int start = 0;
    int end = N - 1;
    int count = 0;

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(token.nextToken());
    }

    Arrays.sort(arr);

    while (start < end) {
      if (arr[start] + arr[end] < M) {
        start++;
      } else if (arr[start] + arr[end] > M) {
        end--;
      } else {
        count++;
        start++;
        end--;
      }
    }

    System.out.println(count);

  }
}
