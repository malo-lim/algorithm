package baekjoon.step.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5597_과제안내신분 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] student = new int[31]; // 30번까지 있기 때문에 1부터 시작
    int count = 0;

    for (int i = 0; i < 28; i++) {
      int number = Integer.parseInt(br.readLine());
      student[number] = 1;
    }

    for (int i = 1; i <= 30; i++) {
      if (student[i] == 0) {
        System.out.println(i);
        count++;
      }
      if (count == 2) {
        break;
      }
    }

  }
}
