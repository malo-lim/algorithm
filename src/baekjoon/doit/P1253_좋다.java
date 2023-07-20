package baekjoon.doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253_좋다 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer token = new StringTokenizer(br.readLine());
    long[] arr = new long[N];
    int answer = 0;

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(token.nextToken());
    }

    Arrays.sort(arr);

    for (int k = 0 ; k < N; k++) {
      long find = arr[k];
      int start = 0;
      int end = N - 1;
      long sum;

      while (start < end) {
        sum = arr[start] + arr[end];

        if (sum == find) {
          if (start != k && end != k) {
            answer++;
            break;
          } else if (start == k) {
            start++;
          } else {
            end--;
          }
        } else if (sum < find) {
          start++;
        } else {
          end--;
        }
      }
    }

    System.out.println(answer);
    br.close();

  }
}
