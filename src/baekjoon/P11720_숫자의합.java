package baekjoon;

import java.util.Scanner;

public class P11720_숫자의합 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String s = sc.next();
    int sum = 0;

    /**
     * 아스키 코드로 char 형태의 숫자를 integer 형태의 숫자로 변경하려면 - '0'을 하거나 - 48을 하면 된다.
     */
    for (char c: s.toCharArray()) {
      sum += c - '0';
    }

    System.out.println(sum);
  }
}
