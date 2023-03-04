package algorithm.sort;

import java.util.Scanner;

public class InsertionSort {

  public int[] solution(int n, int[] arr) {
    int temp = 0;
    int j = 0;

    /*
    1. 1부터 시작해서 왼쪽꺼와 비교한다.
    2. j값이 temp 값보다 크다면 j값을 한칸씩 뒤로 미룬다.(arr[j+1] = arr[j])
    3. 2번이 아니라면 안의 for문을 break한다.
    4. arr[j+1]에 temp를 주입한다.
     */
    for (int i=1; i<n; i++) {
      temp = arr[i];
      for (j=i-1; j>=0; j--) {
        if (arr[j] > temp) {
          arr[j+1] = arr[j];
        } else {
          break;
        }
      }
      arr[j+1] = temp;
    }
    return arr;
  }

  public static void main(String[] args) {
    InsertionSort main = new InsertionSort();
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
