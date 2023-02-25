package algorithm.array;

import java.util.Scanner;

public class Mentoring {

  public int solution(int n, int m, int[][] arr) {
    int answer = 0;
    int count, pi, pj;

    /*
    1. 총 경우의 수는 n*n 이라서 1번부터 n번까지 이중포문을 돌린다.
    2. m번의 테스트를 진행해야하기 때문에 안에 for문을 추가
    3. pi, ps변수를 이용하여 등수를 비교하여 arr[k][s] == i 이면 pi=s, arr[k][s] == j 이면 pj=s;
    4. pi < pj 인경우에 count를 1 증가시킨다.
    5. count가 m번의 테스트를 진행하기 때문에 동일하다면 answer를 1 증가 시킨다.
     */
    for (int i=1; i<=n; i++) {
      for (int j=1; j<=n; j++) {
        count = 0;

        for (int k=0; k<m; k++) {
          pi = 0;
          pj = 0;
          for (int s=0; s<n; s++) {
            if (arr[k][s] == i) {
              pi = s;
            }
            if (arr[k][s] == j) {
              pj = s;
            }
          }
          if (pi < pj) {
            count++;
          }
        }

        if (count == m) {
          answer++;
        }

      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Mentoring main = new Mentoring();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();

    int[][] arr = new int[m][n];

    for (int i=0; i<m; i++) {
      for (int j=0; j<n; j++) {
        arr[i][j] = scanner.nextInt();
      }
    }

    System.out.println(main.solution(n, m, arr));

  }
}
