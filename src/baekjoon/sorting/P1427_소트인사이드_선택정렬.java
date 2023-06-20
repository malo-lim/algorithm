package baekjoon.sorting;

import java.io.*;

public class P1427_소트인사이드_선택정렬 {

  private static void selectionSort(String[] N) {
    int size = N.length;

    // 내림차순 정렬
    for (int i = 0; i < size; i++) {
      int max = Integer.MIN_VALUE;  // 가장 큰 값을 찾기 위해 가장 작은값으로 초기화
      int index = 0;

      for (int j = i; j < size; j++) {
        if (Integer.parseInt(N[j]) > max) {
          max = Integer.parseInt(N[j]);
          index = j;
        }
      }

      String temp = N[i];
      N[i] = N[index];
      N[index] = temp;
    }
  }

  public static void main(String[] args) throws IOException {
    /**
     * 선택정렬은 최소 or 최대값을 찾아서 값을 바꿔주는 것이다.
     */

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] N = br.readLine().split("");

    selectionSort(N);
    for (String s : N) {
      bw.write(s);
    }

    bw.close();
  }

}
