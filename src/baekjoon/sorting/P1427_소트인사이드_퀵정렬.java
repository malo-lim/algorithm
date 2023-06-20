package baekjoon.sorting;

import java.io.*;

public class P1427_소트인사이드_퀵정렬 {

  private static void quickSort(String[] n, int low, int high) {

    if (low < high) {
      int pivot = partition(n, low, high);
      quickSort(n, low, pivot - 1);
      quickSort(n, pivot + 1, high);
    }

  }

  private static int partition(String[] n, int low, int high) {
    int pivot = Integer.parseInt(n[high]);
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (Integer.parseInt(n[j]) <= pivot) {
        i++;
        swap(n, i, j);
      }
    }
    swap(n, i + 1, high);

    return i + 1;
  }

  private static void swap(String[] n, int i, int j) {
    String temp = n[i];
    n[i] = n[j];
    n[j] = temp;
  }

  private static void print(String[] n, BufferedWriter bw) throws IOException {
    for (String s: n) {
      bw.write(s);
    }
    bw.close();
  }

  public static void main(String[] args) throws IOException {
    /**
     * 선택정렬은 최소 or 최대값을 찾아서 값을 바꿔주는 것이다.
     */

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] N = br.readLine().split("");

    quickSort(N, 0, N.length - 1);
    print(N, bw);
  }



}
