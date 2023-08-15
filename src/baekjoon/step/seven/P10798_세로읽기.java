package baekjoon.step.seven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10798_세로읽기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s;
    int length = 0;
    int max = 0;
    char[][] words = new char[5][15];

    for (int i = 0; i < 5; i++) {
      s = br.readLine();
      length = s.length();
      max = Math.max(max, length);

      for (int j = 0; j < length; j++) {
        words[i][j] = s.charAt(j);
      }
    }

    for (int x = 0; x < max; x++) {
      for (int y = 0; y < 5; y++) {
        if (words[y][x] == '\0') {
          continue;
        }
        System.out.print(words[y][x]);
      }
    }

  }
}
