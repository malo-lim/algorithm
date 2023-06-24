package baekjoon.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class P11047_동전0 {

  static int[] coins;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer token = new StringTokenizer(br.readLine());
    N = Integer.parseInt(token.nextToken());
    int M = Integer.parseInt(token.nextToken());

    coins = new int[N];

    for (int i = 0 ; i < N; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    bw.write(Integer.toString(solution(M)));
    bw.close();
  }

  private static int solution(int m) {
    int count = 0;
    int index = N - 1;

    while (m != 0) {
      count += m / coins[index];
      m = m % coins[index];
      index--;
    }

    return count;
  }
}
