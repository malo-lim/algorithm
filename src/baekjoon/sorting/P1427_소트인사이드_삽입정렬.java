package baekjoon.sorting;

import java.io.*;

public class P1427_소트인사이드_삽입정렬 {

  private static void insertionSort(String[] N, BufferedWriter bw) throws IOException {
    int size = N.length;
    int j;

    // 0번의 값은 이미 정렬된 것으로 볼 수 있다.
    // 그래서 1번부터 시작
    for (int i = 1; i < size; i++) {
      int target = Integer.parseInt(N[i]); // 현재 삽입 될 숫자만 i번째 정수를 복사

      // 내림차순 정렬
      for (j = i - 1; j >= 0 && target > Integer.parseInt(N[j]); j--) {
        N[j + 1] = N[j];
      }

      /*
       * 위 반복문에서 탈출 하는 경우 앞의 원소가 타겟보다 크다는 의미이므로
       * 타겟 원소는 j번째 원소 뒤에 와야한다.
       * 그러므로 타겟은 j + 1 에 위치하게 된다.
       */
      N[j + 1] = Integer.toString(target);
    }

    for (String s : N) {
      bw.write(s);
    }
    bw.close();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] N = br.readLine().split("");

    insertionSort(N, bw); // 삽입정렬

  }

}
