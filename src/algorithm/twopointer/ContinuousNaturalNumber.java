package algorithm.twopointer;

import java.util.Scanner;

public class ContinuousNaturalNumber {

  public int solutionMath(int n) {
    int answer = 0;
    int count = 1;

    n = n - count;
    while (n > 0) {
      count++;
      n = n - count;

      if (n % count == 0) {
        answer++;
      }
    }

    return answer;
  }

  public int solutionTwoPointer(int n) {
    int answer = 0;
    int sum = 1;
    int size = (int) Math.round((double) n/2);
    int lt = 1;

    for (int rt=2; rt<=size; rt++) {
      sum += rt;
      if (sum == n) {
        answer++;
      }

      while (sum >= n) {
        sum -= lt;
        lt++;
        if (sum == n) {
          answer++;
        }
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    ContinuousNaturalNumber main = new ContinuousNaturalNumber();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    System.out.println(main.solutionTwoPointer(n));
    System.out.println(main.solutionMath(n));
  }
}
