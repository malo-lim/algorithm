package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1541_잃어버린괄호 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    int answer = 0;

    // -를 기준으로 split 한다.
    String[] split = s.split("-");

    // split 해서 나온 값을 기준으로 첫번째 값이면 더해주고 나머지는 전부 더해서 빼준다.
    for (int i = 0 ; i < split.length; i++) {

      int result = sum(split[i]);

      if (i == 0) {
        answer += result;
      } else {
        answer -= result;
      }
    }

    System.out.println(answer);

  }

  private static int sum(String s) {
    // +를 기준으로 split 하고, 전부 더해준다.
    return Arrays.stream(s.split("[+]"))
        .mapToInt(Integer::parseInt) // string to int convertor
        .sum(); // sum
  }

}
