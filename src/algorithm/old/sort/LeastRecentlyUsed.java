package algorithm.old.sort;

import java.util.Scanner;

public class LeastRecentlyUsed {

  public int[] solution(int s, int n, int[] arr) {
    int[] cache = new int[s];
    int pos = s-1;

    for (int x: arr) {
      /*
      삽입정렬을 이용한 방식
      1. 해당 값이 있다면, 그 인덱스 위치를 기억한다.
      2. 1번의 값이 없다면, s-1부터 뒤로 복사한다.
      3. 캐시의 첫번째 자리(cache[0])에 x를 넣어준다.
       */
      pos = s-1;
      for (int i=s-1; i>=1; i--) {
        if (cache[i] == x) {
          pos = i;
          break;
        }
      }

      for (int i=pos; i>=1; i--) {
        cache[i] = cache[i-1];
      }
      cache[0] = x;
    }

    return cache;
  }

  public static void main(String[] args) {
    LeastRecentlyUsed main = new LeastRecentlyUsed();
    Scanner scanner = new Scanner(System.in);
    int s = scanner.nextInt();
    int n = scanner.nextInt();
    int[] arr = new int[n];

    for (int i=0; i<n; i++) {
      arr[i] = scanner.nextInt();
    }

    for (int num: main.solution(s, n, arr)) {
      System.out.print(num + " ");
    }
  }
}
