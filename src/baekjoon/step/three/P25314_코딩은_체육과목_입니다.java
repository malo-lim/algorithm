package baekjoon.step.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P25314_코딩은_체육과목_입니다 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int count = N / 4;

    System.out.println("long ".repeat(Math.max(0, count)) + "int");
  }
}
