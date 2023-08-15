package baekjoon.doit;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11399_ATM_삽입정렬 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int j;
    int[] arr = new int[N];
    int[] sum = new int[N];
    int size = arr.length;

    StringTokenizer token = new StringTokenizer(br.readLine());
    for (int i = 0; i < size; i++) {
      arr[i] = Integer.parseInt(token.nextToken());
    }

    // 선택정렬
    // 0번의 값은 이미 정렬된 것으로 볼 수 있다.
    for (int i = 1; i < size; i++) {
      int target = arr[i];

      // 오름차순 정렬
      for (j = i - 1; j >= 0 && target < arr[j]; j--) {
        arr[j + 1] = arr[j];
      }

      /*
       * 위 반복문에서 탈출 하는 경우 앞의 원소가 타겟보다 작다는 의미이므로
       * 타겟 원소는 j번째 원소 뒤에 와야한다.
       * 그러므로 타겟은 j + 1 에 위치하게 된다.
       */
      arr[j + 1] = target;
    }

    // 합배열 만들기(구간합)
    sum[0] = arr[0];
    for (int i = 1; i < N; i++) {
      sum[i] = sum[i-1] + arr[i];
    }

    bw.write(String.valueOf(Arrays.stream(sum).sum()));
    bw.close();
    br.close();

  }
}
