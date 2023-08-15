package baekjoon.doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10986_나머지합구하기 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer sc = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(sc.nextToken());
    int M = Integer.parseInt(sc.nextToken());

    long[] S = new long[N];
    long[] C = new long[M];
    long answer = 0;

    sc = new StringTokenizer(br.readLine());

    S[0] = Long.parseLong(sc.nextToken());

    // 구간합 구하기
    for (int i = 1; i < N; i++) {
      S[i] = S[i - 1] + Long.parseLong(sc.nextToken());
    }

    for (int i = 0; i < N; i++) {
      // 합 배열의 모든 값에 % 연산 수행하기
      int remainder = (int) (S[i] % M);
      // 0 ~ i 까지의 구간 합 자체가 0일 때 정답에 더하기
      if (remainder == 0) {
        answer++;
      }
      // 나머지가 같은 인덱스의 개수 카운팅
      C[remainder]++;
    }

    for (int i = 0; i < M; i++) {
      if (C[i] > 1) {
        // 나머지가 같은 인덱스 중 2개를 뽑느 경우의 수를 더하기
        answer = answer + (C[i] * (C[i] - 1) / 2);
      }
    }

    System.out.println(answer);

  }
}
