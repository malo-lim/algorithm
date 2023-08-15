package baekjoon.step.eight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2903_중앙이동알고리즘 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    // 처음 점이 2개, 그다음점이 3개, 그다음이 5개 형태로써, 증가하는 값이 1,2,4,8 형태로 2의 제곱근만큼 증가한다.
    int point = (int) Math.pow(2, N) + 1; // 1,2,4,8,16,32,64 형태로 증가한다. 즉 2의 제곱근 수이다.

    /*
     점의 개수(point)^2의 값이 답이다
     0번일경우 점이 2개, 답은 4
     1번일경우 점이 3개, 답은 9
     2번일경우 점이 5개, 답은 25
     3번일경우 점이 9개, 답은 81
     4번일경우 점이 17개, 답은 289
     5번일경우 점이 33개, 답은 1089
     즉, 점은 2의 제곱근 만큼 늘어나고, 답은 점을 제곱한것과 같다.
     */
    long total = (long) Math.pow(point, 2);
    System.out.println(total);
  }
}
