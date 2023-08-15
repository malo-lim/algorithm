package baekjoon.step.nine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P9506_약수들의합 {

  private static String solution(int n) {
    StringBuilder sb = new StringBuilder();
    List<Integer> list = new ArrayList<>();
    int total = 0;

    for (int i = 1; i <= n / 2; i++) {
      if (n % i == 0) {
        list.add(i);
        total += i;
      }
    }

    if (total != n) {
      sb.append(n).append(" is NOT perfect.");
    } else {
      sb.append(n).append(" = ");
      for (int i=0, size = list.size(); i < size; i++) {
        sb.append(list.get(i)).append(" + ");
      }
      sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(" + ")));
    }

    return sb.toString();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n;

    while ((n = Integer.parseInt(br.readLine())) != -1) {
      System.out.println(solution(n));
    }
  }
}
