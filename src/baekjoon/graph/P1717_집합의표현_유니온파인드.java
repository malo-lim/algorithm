package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1717_집합의표현_유니온파인드 {

  static int[] arr;

  private static final int UNION = 0;
  private static final int CONFIRM = 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int n = Integer.parseInt(s[0]);
    int m = Integer.parseInt(s[1]);

    // 1부터 시작하기 위해서 + 1 해준다.
    arr = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      arr[i] = i;
    }

    for (int i = 0; i < m; i++) {
      // 질의 계산하는 부분
      s = br.readLine().split(" ");
      int question = Integer.parseInt(s[0]);
      int from = Integer.parseInt(s[1]);
      int to = Integer.parseInt(s[2]);

      if (question == UNION) {
        union(from, to);
      } else if (question == CONFIRM) {
        if (isSame(from, to)) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }
      }
    }

  }

  private static int find(int v) {
    // 대표노드인지 확인
    if (arr[v] == v) {
      return v;
    } else {
      // 대표노드가 아니면
      // value 값을 인덱스로 바꿔서 찾고, 그 값을 그때의 대표노드 값을 업데이트 쳐준다. (경로 압축)
      return arr[v] = find(arr[v]);
    }
  }

  private static void union(int from, int to) {
    int findFrom = find(from);
    int findTo = find(to);

    if (findFrom != findTo) {
      arr[findFrom] = findTo; // 두 값의 연결
    }
  }

  private static boolean isSame(int from, int to) {
    return find(from) == find(to);
  }

}
