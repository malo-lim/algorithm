package algorithm.old.slidingwindow;

import java.util.Scanner;

public class MaxSales {

  public int solution(int n, int k, int[] sales) {
    int answer = 0;
    int sum = 0;

    for (int i=0; i<k; i++) {
      sum += sales[i];
    }

    answer = sum;
    for (int i=k; i<n; i++) {
      sum = sum + sales[i] - sales[i-k];
      answer = Math.max(answer, sum);
    }

    return answer;
  }

  public static void main(String[] args) {
    MaxSales main = new MaxSales();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int k = scanner.nextInt();
    int[] sales = new int[n];

    for (int i=0; i<n; i++) {
      sales[i] = scanner.nextInt();
    }

    System.out.println(main.solution(n, k, sales));
  }
}
