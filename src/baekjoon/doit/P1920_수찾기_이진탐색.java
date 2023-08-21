package baekjoon.doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920_수찾기_이진탐색 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] list = new int[N];

    for (int i = 0; i < N; i++) {
      list[i] = Integer.parseInt(st.nextToken());
    }

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    Arrays.sort(list);

    for (int i = 0; i < M; i++) {
      boolean isFind = false;
      int target = Integer.parseInt(st.nextToken());

      // 이진 탐색 시작
      int start = 0;
      int end = list.length - 1;

      while (start <= end) {
        int middleIndex = (start + end) / 2;
        int middleValue = list[middleIndex];

        if (middleValue > target) {
          end = middleIndex - 1;
        } else if (middleValue < target) {
          start = middleIndex + 1;
        } else {
          isFind = true;
          break;
        }
      }

      System.out.println(isFind ? 1 : 0);

    }


  }
}
