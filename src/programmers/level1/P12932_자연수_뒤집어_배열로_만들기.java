package programmers.level1;

import java.util.Arrays;
import java.util.Scanner;

public class P12932_자연수_뒤집어_배열로_만들기 {

  public int[] solution(long n) {
    int[] answer = {};
    String s = Long.toString(n);
    String reverse = new StringBuilder(s).reverse().toString();
    char[] chars = reverse.toCharArray();
    answer = new int[chars.length];

    for (int i = 0; i < chars.length; i++) {
      answer[i] = chars[i] - '0';
    }

    return answer;
  }

  public static void main(String[] args) {
    P12932_자연수_뒤집어_배열로_만들기 main = new P12932_자연수_뒤집어_배열로_만들기();
    Scanner sc = new Scanner(System.in);
    long n = sc.nextLong();

    System.out.println(Arrays.toString(main.solution(n)));

  }
}
