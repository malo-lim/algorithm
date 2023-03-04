package algorithm.sort;

import java.util.Scanner;

public class MusicVideo {

  public int solution(int n, int m, int[] arr) {
    int answer = 0;



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
