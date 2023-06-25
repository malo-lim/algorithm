package algorithm.old.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommonElement {

  public List<Integer> solution(int n, int m, int[] arrN, int[] arrM) {
    List<Integer> answer = new ArrayList<>();
    Arrays.sort(arrN);
    Arrays.sort(arrM);

    int p1 = 0;
    int p2 = 0;

    while (p1 < n && p2 < m) {
      if (arrN[p1] == arrM[p2]) {
        answer.add(arrN[p1++]);
        p2++;
      } else if (arrN[p1] < arrM[p2]) {
        p1++;
      } else {
        p2++;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    CommonElement main = new CommonElement();
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

    for (int num: main.solution(n, m, arrN, arrM)) {
      System.out.print(num + " ");
    }
  }
}
