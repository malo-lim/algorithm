package algorithm.old.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReversePrime {

  public boolean isPrime(int n) {
    if (n == 1) {
      return false;
    }

    for (int i=2; i<=Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }

  public List<Integer> solution(int n, int[] arr) {
    List<Integer> answer = new ArrayList<>();
    int temp =0, result=0, t=0;

    for (int i=0; i<n; i++) {
      temp = arr[i];
      result = 0;

      while (temp > 0) {
        // 숫자 뒤집는 공식
        t = temp % 10;
        result = result * 10 + t;
        temp = temp / 10;
      }

      if (isPrime(result)) {
        answer.add(result);
      }

    }

    return answer;
  }

  public static void main(String[] args) {
    ReversePrime main = new ReversePrime();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arr = new int[n];

    for (int i=0; i<n; i++) {
      arr[i] = scanner.nextInt();
    }

    for (Integer number: main.solution(n, arr)) {
      System.out.print(number + " ");
    }

  }
}
