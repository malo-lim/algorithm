package baekjoon.doit;

import java.io.*;

public class P2023_신기한소수 {
  static int N;
  static int[] prime = {1, 3, 5, 7, 9};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    // 1자리수의 소수 2,3,5,7의 탐색을 시작한다.
    dfs(2, 1);
    dfs(3, 1);
    dfs(5, 1);
    dfs(7, 1);

    br.close();
  }

  private static void dfs(int num, int digit) throws IOException {

    // 자릿수라면 소수 판별
    if (digit == N) {
      if (isPrime(num)) {
        System.out.println(num);
      }
      return;
    }

    for (int i : prime) {
      // 한자릿수를 늘린 값이 소수라면 자릿수를 늘려서 계속 탐색
      if (isPrime(num * 10 + i)) {
        dfs(num * 10 + i, digit + 1);
      }
    }
  }

  private static boolean isPrime(int num) {

    for (int i = 2; i <= num / 2; i++) {
      if (num % i == 0) {
        return false;
      }
    }

    return true;
  }
}
