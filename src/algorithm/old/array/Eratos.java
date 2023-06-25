package algorithm.old.array;

import java.util.Scanner;

public class Eratos {

  public int solution(int n) {
    int answer = 0;
    int[] ch = new int[n+1];

    for (int i=2; i<=n; i++) {
      if (ch[i] == 0) {
        answer++;
        for (int j=i; j<=n; j=j+i) {
          ch[j] = 1;
        }
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Eratos main = new Eratos();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    System.out.println(main.solution(n));
  }
}
