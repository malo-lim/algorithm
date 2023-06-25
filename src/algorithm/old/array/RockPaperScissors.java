package algorithm.old.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RockPaperScissors {

  public List<String> solution(int[] a, int[] b) {
    List<String> result = new ArrayList<>();
    int size = a.length;

    for (int i=0; i<size; i++) {
      if (a[i] == b[i]) {
        result.add("D");
      } else if (a[i] == 1 && b[i] == 3) {
        result.add("A");
      } else if (a[i] == 2 && b[i] == 1) {
        result.add("A");
      } else if (a[i] == 3 && b[i] == 2) {
        result.add("A");
      } else {
        result.add("B");
      }
    }

    return result;
  }

  public static void main(String[] args) {
    RockPaperScissors main = new RockPaperScissors();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];

    for (int i=0; i<n; i++) {
      a[i] = scanner.nextInt();
    }

    for (int i=0; i<n; i++) {
      b[i] = scanner.nextInt();
    }

    for (String result: main.solution(a, b)) {
      System.out.println(result);
    }
  }
}
