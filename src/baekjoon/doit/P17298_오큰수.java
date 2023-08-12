package baekjoon.doit;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class P17298_오큰수 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] A = new int[n];
    int[] answer = new int[n];
    String[] str = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      A[i] = Integer.parseInt(str[i]);
    }
    Stack<Integer> stack = new Stack<>();
    stack.push(0); // 처음에는 항상 스택이 비어 있으므로 최초 값을 push 해서 초기화

    for (int i = 1; i < n; i++) {
      // 스택이 비어 있지 않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 클 경우
      while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
        answer[stack.pop()] = A[i]; // 정답 배열에 오큰수를 현재 수열로 저장하기
      }
      stack.push(i);
    }

    while (!stack.empty()) {
      // 반복문을 다 돌고 나왔는데 스택이 비어 있지 않다면 빌 때까지
      answer[stack.pop()] = -1;
      // 스택에 쌓인 index에 -1을 넣고
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < n; i++) {
      bw.write(answer[i] + " ");
    }
    bw.write("\n");
    bw.flush();
  }
}
