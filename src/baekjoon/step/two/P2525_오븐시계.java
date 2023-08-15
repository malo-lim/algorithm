package baekjoon.step.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2525_오븐시계 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");

    int hour = Integer.parseInt(s[0]);
    int minute = Integer.parseInt(s[1]);
    int add = Integer.parseInt(br.readLine());

    hour = (hour + ((minute + add) / 60)) % 24;
    minute = (minute + add) % 60;

    System.out.println(hour + " " + minute);
  }
}
