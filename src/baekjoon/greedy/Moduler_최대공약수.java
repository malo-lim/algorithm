package baekjoon.greedy;

public class Moduler_최대공약수 {

  private static int gcd(int n1, int n2) {
    int mod = 0;

    // 유클리드 호제법
    /*
    1. n1, n2 중에 더 큰 값을 n1, 작은 값을 n2 에 대입
    반복
    2. n1 % n2를 해서 나머지를 저장
    3. n2(작은값)과 나머지를 비교하여 큰값을 n1에 대입
    4. n2(작은값)과 나머지를 비교하여 작은값을 n2에 대입
     */
    if (n1 < n2) {
      int temp = n1;
      n1 = n2;
      n2 = temp;
    }

    while (n1 % n2 != 0) {
      mod = n1 % n2;
      n1 = Math.max(n2, mod);
      n2 = Math.min(n2, mod);
    }

    return mod;
  }

  public static void main(String[] args) {
    System.out.println(gcd(192, 270)); // 최대 공약수
    System.out.println((270 * 192) / gcd(270, 192)); // 최소 공배수 (n1 * n2) / n1,n2의 최소 공배수
  }
}
