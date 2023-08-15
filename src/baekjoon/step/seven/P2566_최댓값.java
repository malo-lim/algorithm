package baekjoon.step.seven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2566_최댓값 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer token;
    int idxI = 0;
    int idxJ = 0;
    int max = 0;

    for (int i = 0; i < 9; i++) {
      token = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; j++) {
        int value = Integer.parseInt(token.nextToken());
        if (max < value) {
          max = value;
          idxI = i;
          idxJ = j;
        }
      }
    }
    System.out.println(max);
    System.out.println((idxI + 1) + " " + (idxJ + 1));
  }
}
