package algorithm.old.twopointer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombineArray {

  public List<Integer> solution(int n, int[] arrN, int m, int[] arrM) {
    List<Integer> answer = new ArrayList<>();
    int p1 = 0, p2 = 0;

    while (p1 < n && p2 < m) {
      // arrN의 첫번째와 arrM의 첫번째를 비교 후에 값이 작은걸 answer에 넣어준다.
      if (arrN[p1] < arrM[p2]) {
        answer.add(arrN[p1++]);
      } else {
        answer.add(arrM[p2++]);
      }
    }

    // 남아 있는 값을 모르니까 나머지 값을 모두 추가해준다.
    while (p1 < n) {
      answer.add(arrN[p1++]);
    }

    while (p2 < m) {
      answer.add(arrM[p2++]);
    }

    return answer;
  }

  public static void main(String[] args) {
    CombineArray main = new CombineArray();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arrN = new int[n];

    for (int i=0; i<n; i++) {
      arrN[i] = scanner.nextInt();
    }

    int m = scanner.nextInt();
    int[] arrM = new int[m];

    for (int i=0; i<m; i++) {
      arrM[i] = scanner.nextInt();
    }

    for (int num: main.solution(n, arrN, m, arrM)) {
      System.out.print(num + " ");
    }

  }
}
