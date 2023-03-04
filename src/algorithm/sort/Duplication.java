package algorithm.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Duplication {

  public Character solutionHash(int n, int[] arr) {
    Character answer = 'U';
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int x: arr) {
      map.put(x, map.getOrDefault(x, 0) + 1);

      if (map.get(x) > 1) {
        return 'D';
      }
    }

    return answer;
  }
  public Character solutionSort(int n, int[] arr) {
    Character answer = 'U';
    Arrays.sort(arr);

    for (int i=0; i<n-1; i++) {
      if (arr[i] == arr[i+1]) {
        return 'D';
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Duplication main = new Duplication();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arr = new int[n];

    for (int i=0; i<n; i++) {
      arr[i] = scanner.nextInt();
    }

    System.out.println(main.solutionHash(n, arr));
    System.out.println(main.solutionSort(n, arr));
  }
}
