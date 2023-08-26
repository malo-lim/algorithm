package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P172928_공원산책 {

  private static final int[] dx = {1, -1, 0, 0};
  private static final int[] dy = {0, 0, -1, 1};

  private static Map<String, Integer> makeOp() {
    Map<String, Integer> op = new HashMap<>();
    op.put("E", 0);
    op.put("W", 1);
    op.put("N", 2);
    op.put("S", 3);

    return op;
  }

  private static int[] solution(String[] park, String[] routes) {
    Map<String, Integer> direction = makeOp();

    int x = 0, y = 0;
    int H = park.length; // 세로 길이
    int W = park[0].length(); // 가로 길이

    String[][] graph = new String[H][W];

    for (int i = 0; i < park.length; i++) {
      for (int j = 0; j < park[i].length(); j++) {
        String s = String.valueOf(park[i].charAt(j));
        graph[i][j] = s;

        if ("S".equals(s)) {
          y = i;
          x = j;
        }
      }
    }

    for (String route : routes) {
      boolean needsSwap = true;
      String[] split = route.split(" ");

      String op = split[0];
      int n = Integer.parseInt(split[1]);

      int nx = x, ny = y;

      for (int i = 0; i < n; i++) {
        ny = ny + dy[direction.get(op)];
        nx = nx + dx[direction.get(op)];

        if (nx < 0 || ny < 0 || nx >= W || ny >= H || "X".equals(graph[ny][nx])) {
          needsSwap = false;
          break;
        }
      }

      if (needsSwap) {
        y = ny;
        x = nx;
      }
    }

    return new int[] {y, x};
  }

  public static void main(String[] args) {
    String[] park = {"OSO","OOO","OXO","OOO"};
    String[] routes = {"E 2","S 3","W 1"};

    System.out.println(Arrays.toString(solution(park, routes)));
  }
}
