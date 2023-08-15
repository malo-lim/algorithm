package baekjoon.step.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P10807_개수세기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer token = new StringTokenizer(br.readLine());
    int v = Integer.parseInt(br.readLine());

    Map<Integer, Integer> map = new HashMap<>();

    while (token.hasMoreTokens()) {
      int n = Integer.parseInt(token.nextToken());
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    System.out.println(map.get(v) == null ? 0 : map.get(v));

  }
}
