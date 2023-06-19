package baekjoon.sorting;

import java.io.*;

public class P2750_수정렬하기_버블정렬 {

  private static void bubbleSort(int[] arr, int N) {
    for (int i = 0; i < N-1; i++) {
      for (int j = 0; j < N-1-i; j++) {
        if (arr[j] > arr[j+1]) {
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
      }
    }
  }

  private static void print(BufferedWriter bw, int[] arr) throws IOException {
    for (int x: arr) {
      bw.write("" + x);
      bw.newLine();
    }
    bw.close();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    bubbleSort(arr, N);
    print(bw, arr);

  }
}
