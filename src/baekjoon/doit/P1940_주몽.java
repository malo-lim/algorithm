package baekjoon.doit;

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
    int[] arr = new int[N];
    StringTokenizer token = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(token.nextToken());
    }

    Arrays.sort(arr);
    int start = 0;
    int end = N - 1;
    int sum;
    int count = 0;

    while (start < end) {
      sum = arr[start] + arr[end];
      if (sum == M) {
        count++;
        start++;
        end--;
      } else if (sum > M) {
        end--;  
      } else {
        start++;
      }
    }

    System.out.println(count);
    br.close();

  }
}
