package algorithm.array;

import java.util.Scanner;

public class StudentRank {

  public int[] solution(int n, int[] arr) {
    int[] answer = new int[n];
    int count = 1;

    for (int i=0; i<n; i++) {
      count = 1;
      for (int j=0; j<n; j++) {
        if (arr[j] > arr[i]) {
          count++;
        }
      }
      answer[i] = count;
    }

    return answer;
  }

  public static void main(String[] args) {
    StudentRank main = new StudentRank();
    Scanner scanner= new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arr = new int[n];

    for (int i=0; i<n; i++) {
      arr[i] = scanner.nextInt();
    }

    for (int num: main.solution(n, arr)) {
      System.out.print(num + " ");
    }
  }
}
