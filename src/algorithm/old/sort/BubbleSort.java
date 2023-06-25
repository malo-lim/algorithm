package algorithm.old.sort;

import java.util.Scanner;

public class BubbleSort {

  public int[] solution(int n, int[] arr) {
    int temp = 0;
    
    // 인접한 두 수를 비교하여 값을 바꿈
    for (int i=0; i<n-1; i++) {
      for (int j=0; j<n-i-1; j++) {
        if (arr[j] > arr[j+1]) {
          temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
      }
    }

    return arr;
  }

  public static void main(String[] args) {
    BubbleSort main = new BubbleSort();
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
