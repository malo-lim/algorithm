package baekjoon.step.six;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P2444_별찍기 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    Stack<String> stack = new Stack<>();

    for (int j = 1; j <= N; j++) {
      StringBuilder str = new StringBuilder();
      for (int i = 1; i <= N + j - 1; i++) {
        if (i <= N - j) {
          sb.append(" ");
          str.append(" ");
        } else {
          sb.append("*");
          str.append("*");
        }
      }
      sb.append("\n");
      str.append("\n");
      stack.push(str.toString());
    }
    System.out.print(sb);
    stack.pop();
    while (!stack.isEmpty()) {
      System.out.print(stack.pop());
    }
  }
}
