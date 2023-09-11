package practice.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2744_대소문자_바꾸기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String read = br.readLine();
    StringBuilder sb = new StringBuilder();

    for (char c: read.toCharArray()) {
      if (c >= 'A' && c <= 'Z') {
        sb.append((char) ('a' + c - 'A'));
      } else if (c >= 'a' && c <= 'z') {
        sb.append((char) ('A' + c - 'a'));
      }
    }

    System.out.println(sb);
  }
}
