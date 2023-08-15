package baekjoon.step.seven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2563_색종이 {
  /*
  1. 우선 이 도화지를 나타낼 int형 배열을 크기가 [100][100]인 배열 arr을 선언한다.
  -> 만약에 어떤 수 x, y에 대해 arr [x][y]가 1면 그 부분은 색종이가 붙어져 있다는 것을 뜻한다.
  3. for-loop을 이용해서 색종이 N개를 입력받는다.
  4. 그리고 색종이의 왼쪽 변의 점 x, y가 주어지면 (x, y)부터 (x + 9, y + 9)까지 색종이가 붙어져 있다는 것을 의미한다.
    -> 따라서 이중 for-loop을 이용해 arr [x][y]부터 arr [x+9][y+9]를 1로 시켜준다. 그리고 맨 마지막에 1인 개수를 출력하면 된다.
   */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer token;
    int total = 0;
    int[][] arr = new int[100][100];

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      token = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(token.nextToken());
      int y = Integer.parseInt(token.nextToken());

      for (int j = x; j < x + 10; j++) {
        for (int k = y; k < y + 10; k++) {
          arr[j][k] = 1;
        }
      }
    }

    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        if (arr[i][j] == 1) {
          total++;
        }
      }
    }

    System.out.println(total);

  }
}
