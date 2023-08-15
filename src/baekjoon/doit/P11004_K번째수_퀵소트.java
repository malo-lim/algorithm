package baekjoon.doit;

import java.io.*;
import java.util.StringTokenizer;

public class P11004_K번째수_퀵소트 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer token = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(token.nextToken());
    int K = Integer.parseInt(token.nextToken());
    token = new StringTokenizer(br.readLine());

    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(token.nextToken());
    }

    quickSort(A, 0, N - 1, K - 1);
    bw.write(String.valueOf(A[K - 1]));
    bw.close();
    br.close();
  }

  private static void quickSort(int[] A, int S, int E, int K) {
    if (S < E) {
      int pivot = partition(A, S, E);
      if (pivot == K) {
        return;
      } else if (K < pivot) {
        quickSort(A, S, pivot -1, K);
      } else {
        quickSort(A, pivot +1, E, K);
      }
    }

  }

  private static int partition(int[] A, int S, int E) {
    if (S +1 == E) {
      if (A[S] > A[E]) {
        swap(A, S, E);
      }
      return E;
    }
    int M = (S + E) / 2;
    swap(A, S, M);
    int pivot = A[S];
    int i = S + 1, j = E;
    while (i <= j) {
      while (pivot < A[j] && j > 0) {
        // 피벗보다 작은 수가 나올때까지
        j--;
      }
      while (pivot > A[i] && i < A.length-1) {
        // 피벗보다 큰 수가 나올때 까지
        i++;
      }
      if (i <= j) {
        swap(A, i++, j--);
      }
    }

    A[S] = A[j];
    A[j] = pivot;
    return j;
  }

  private static void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }
}
