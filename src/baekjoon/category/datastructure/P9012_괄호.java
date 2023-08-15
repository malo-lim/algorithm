package baekjoon.category.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9012_괄호 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int i = 0; i < T; i++) {
      String s = br.readLine();
      int result = 0;

      for (char c: s.toCharArray()) {
        if (c == '(') {
          result++;
        } else {
          result--;
        }

        // -1이 되면 더이상 진행하지 않고 끝낸다.
        if (result == -1) {
          break;
        }
      }

      if (result == 0) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
}
