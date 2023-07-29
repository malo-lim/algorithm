package baekjoon.doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2018_수들의합5 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int start = 1, end = 1, count = 1, sum = 1;

    while (end != N) {
      if (sum == N) {
        count++;
        end++;
        sum += end;
      } else if (sum > N) {
        sum -= start;
        start++;
      } else {
        end++;
        sum += end;
      }
    }

    System.out.println(count);

  }
}
