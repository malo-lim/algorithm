package baekjoon.doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2343_기타레슨 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] list = new int[N];

    int start = Integer.MIN_VALUE;
    int end = 0;

    for (int i = 0; i < N; i++) {
      list[i] = Integer.parseInt(st.nextToken());
      start = Math.max(start, list[i]); // 시작 인덱스 저장(배열 중 최댓값)
      end += list[i]; // 종료 인덱스 저장(배열의 총합)
    }

    while (start <= end) {
      int middle = (start + end) / 2; // 중간 값
      int sum = 0; // 레슨 합
      int count = 0; // 현재 사용한 블루레이 개수

      for (int i = 0; i < N; i++) {
        if (sum + list[i] > middle) {
          count++;
          sum = 0;
        }
        sum += list[i];
      }

      // 레슨 합이 0이 아니면 마지막 블루레이가 필요하므로 count값 올리기
      if (sum != 0) {
        count++;
      }

      if (count > M) {
        // 중간 인덱스값으로 모든 레슨 저장 불가능
        start = middle + 1;
      } else {
        // 중간 인덱스값을 모든 레슨 저장 가능
        end = middle - 1;
      }
    }
    System.out.println(start);
  }
}
