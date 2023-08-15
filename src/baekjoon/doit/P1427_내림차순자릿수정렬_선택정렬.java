package baekjoon.doit;

import java.io.*;

public class P1427_내림차순자릿수정렬_선택정렬 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] s = br.readLine().split("");
    int[] arr = new int[s.length];

    for (int i = 0; i < s.length; i++) {
      arr[i] = Integer.parseInt(s[i]);
    }

    int length = arr.length;

    for (int i = 0; i < length; i++) {
      int max = i;
      for (int j = i + 1; j < length; j++) {
        if (arr[max] < arr[j]) {
          max = j;
        }
      }
      if (arr[max] > arr[i]) {
        swap(arr, max, i);
      }
    }

    for (int i : arr) {
      bw.write(String.valueOf(i));
    }

    bw.close();
    br.close();
  }

  private static void swap(int[] arr, int max, int idx) {
    int temp = arr[max];
    arr[max] = arr[idx];
    arr[idx] = temp;
  }
}
