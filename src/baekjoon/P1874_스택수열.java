package baekjoon;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class P1874_스택수열 {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] sequence = new int[n];
    int number = 1;
    boolean result = true;
    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      sequence[i] = sc.nextInt();
    }

    for (int i = 0; i < n; i++) {
      if (sequence[i] >= number) {
        while (sequence[i] >= number) {
          stack.push(number++);
          sb.append("+\n");
        }
        stack.pop();
        sb.append("-\n");
      } else {
        int j = stack.pop();
        if (j > sequence[i]) {
          System.out.println("NO");
          result = false;
          break;
        } else {
          sb.append("-\n");
        }
      }
    }

    if (result) {
      System.out.println(sb.toString());
    }
  }
}
