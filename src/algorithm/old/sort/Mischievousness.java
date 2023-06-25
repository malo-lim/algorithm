package algorithm.old.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Mischievousness {

  public List<Integer> solution(int n, int[] arr) {
    int[] temp = arr.clone();
    List<Integer> answer = new ArrayList<>(2);
    Arrays.sort(temp);

    for (int i=0; i<n; i++) {
      if (arr[i] != temp[i]) {
        answer.add(i+1);
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Mischievousness main = new Mischievousness();
    Scanner scanner = new Scanner(System.in);
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
