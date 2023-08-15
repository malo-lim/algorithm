package baekjoon.step.nine;

import java.io.*;

public class P5086_배수와약수 {

  private static String solution(int one, int two) {
    String answer = "";

    if (two % one == 0) {
      answer = "factor";
    } else if (one % two == 0) {
      answer = "multiple";
    } else {
      answer = "neither";
    }

    return answer;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while (true) {
      String[] s = br.readLine().split(" ");
      if (s[0].equals(s[1])) {
        break;
      }

      bw.write(solution(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
      bw.newLine();
    }

    br.close();
    bw.close();
  }
}
