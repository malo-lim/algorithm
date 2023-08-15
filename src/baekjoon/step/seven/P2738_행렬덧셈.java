package baekjoon.step.seven;

import java.io.*;
import java.util.Arrays;

public class P2738_행렬덧셈 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] s = br.readLine().split(" ");
    int N = Integer.parseInt(s[0]);
    int M = Integer.parseInt(s[1]);

    int[][] A = new int[N][M];
    int[][] B = new int[N][M];

    for (int i = 0; i < N; i++) {
      s = br.readLine().split(" ");
      for (int j = 0; j < M; j++) {
        A[i][j] = Integer.parseInt(s[j]);
      }
    }

    for (int i = 0; i < N; i++) {
      s = br.readLine().split(" ");
      for (int j = 0; j < M; j++) {
        B[i][j] = Integer.parseInt(s[j]);
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        bw.write(A[i][j] + B[i][j] + " ");
      }
      bw.newLine();
    }

    bw.close();
    br.close();
  }
}
