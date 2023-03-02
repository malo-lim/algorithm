package algorithm.sort;

import java.util.Scanner;

public class SelectionSort {

  public int[] solution(int n, int[] arr) {
    int temp = 0;
    int index = 0;

    // 최솟값을 찾아서 맨 앞으로 이동하는 방식
    for (int i=0; i<n-1; i++) {
      index = i;
      for (int j=i+1; j<n; j++) {
        if (arr[j] < arr[index]) {
          index = j;
        }
      }
      temp = arr[i];
      arr[i] = arr[index];
      arr[index] = temp;
    }

    return arr;
  }

  public static void main(String[] args) {
    SelectionSort main = new SelectionSort();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arr = new int[n];

    for (int i=0; i<n; i++) {
      arr[i] = scanner.nextInt();
    }

    for (int num: main.solution(n, arr)) {
      System.out.print(num + " ");
    }

  }
}
