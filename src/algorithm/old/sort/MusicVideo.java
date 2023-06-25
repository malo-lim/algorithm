package algorithm.old.sort;

import java.util.Arrays;
import java.util.Scanner;

public class MusicVideo {

  public boolean isPossible(int[] arr, int capacity, int m) {
    int sum = 0;
    int count = 1;

    for (int x: arr) {
      if (sum+x > capacity) {
        count++;
        sum = x;
      } else {
        sum += x;
      }
    }

    return count <= m;
  }

  public int solution(int n, int m, int[] arr) {
    int answer = 0;
    int lt = Arrays.stream(arr).max().getAsInt();
    int rt = Arrays.stream(arr).sum();
    int mid = 0;

    while (lt <= rt) {
      mid = (lt + rt) / 2;

      if (isPossible(arr, mid, m)) {
        answer = mid;
        rt = mid - 1;
      } else {
        lt = mid + 1;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    MusicVideo main = new MusicVideo();
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
