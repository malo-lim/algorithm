package baekjoon.step.six;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10988_팰린드롬인지확인하기 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    int length = s.length();
    int start = 0;
    int end = length - 1;
    boolean isPalindrome = true;

    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        isPalindrome = false;
        break;
      }
      start++;
      end--;
    }

    System.out.println(isPalindrome ? 1 : 0);
  }
}
