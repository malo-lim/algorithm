package baekjoon.step.six;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P25206_너의평점은 {
  private static final Map<String, Double> SCORE = new HashMap<>();

  public static void main(String[] args) throws IOException {
    // P는 제외
    addScore();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    double scoreTotal = 0.0;
    double credit = 0.0;

    for (int i = 0; i < 20; i++) {
      String[] s = br.readLine().split( " ");

      if (!"P".equals(s[2])) {
        credit += Double.parseDouble(s[1]);
        scoreTotal += Double.parseDouble(s[1]) * SCORE.get(s[2]);
      }
    }

    System.out.printf("%.6f%n", scoreTotal / credit);

  }

  private static void addScore() {
    SCORE.put("A+", 4.5);
    SCORE.put("A0", 4.0);
    SCORE.put("B+", 3.5);
    SCORE.put("B0", 3.0);
    SCORE.put("C+", 2.5);
    SCORE.put("C0", 2.0);
    SCORE.put("D+", 1.5);
    SCORE.put("D0", 1.0);
    SCORE.put("F", 0.0);
  }

}
