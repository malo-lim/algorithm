package algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

public class BipartiteGraph {

  public int solution(int n, int m, int[] arr) {
    int answer = 0;
    int mid = 0;
    int lt = 0, rt = n-1;
    Arrays.sort(arr);

    while (lt <= rt) {
      mid = (lt + rt) / 2;

      if (arr[mid] == m) {
        return mid + 1;
      } else if (arr[mid] > m) {
        rt = mid - 1;
      } else {
        lt = mid + 1;
      }

    }

    return answer;
  }

  public static void main(String[] args) {
    BipartiteGraph main = new BipartiteGraph();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int[] arr = new int[n];

    for (int i=0; i<n; i++) {
      arr[i] = scanner.nextInt();
    }

    System.out.println(main.solution(n, m, arr));
  }
}
