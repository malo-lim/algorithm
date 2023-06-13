package baekjoon;

import java.util.Scanner;

public class P2018_수들의합5 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int sum = 1;
    int count = 1; // 자기 자신의 숫자
    int start = 1;
    int end = 1;

    while (end != N) {
      if (sum < N) {
        end++;
        sum += end;
      } else if (sum == N) {
        end++;
        sum += end;
        count++;
      } else {
        sum -= start;
        start++;
      }
    }
    System.out.println(count);
  }
}
