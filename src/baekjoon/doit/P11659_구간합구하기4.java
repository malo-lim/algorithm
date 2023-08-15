package baekjoon.doit;

import java.io.*;
import java.util.StringTokenizer;

public class P11659_구간합구하기4 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer token = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(token.nextToken());
    int M = Integer.parseInt(token.nextToken());

    int[] S = new int[N + 1];

    token = new StringTokenizer(br.readLine());
    for (int i = 1 ; i <= N; i++) {
      S[i] = S[i - 1] + Integer.parseInt(token.nextToken());
    }

    for (int t = 0; t<M; t++) {
      token = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(token.nextToken());
      int j = Integer.parseInt(token.nextToken());

      bw.write(Integer.toString(S[j] - S[i - 1]));
      bw.newLine();
    }
    bw.close();
    br.close();

  }
}
