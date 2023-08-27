package programmers.level1;


import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P176963_추억점수 {

  private static int[] solution(String[] name, int[] yearning, String[][] photo) {
    int[] answer = new int[photo.length];

    Map<String, Integer> photoScore = IntStream.range(0, name.length)
        .boxed()
        .collect(
            Collectors.toMap(i -> name[i], i -> yearning[i], (a, b) -> b, HashMap::new)
        );

    for (int i = 0; i < photo.length; i++) {
      for (String s : photo[i]) {
        answer[i] += photoScore.getOrDefault(s, 0);
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    String[] name = {"may", "kein", "kain", "radi"};
    int[] yearning = {5, 10, 1, 3};
    String[][] photo = {
        {"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}
    };

    System.out.println(Arrays.toString(solution(name, yearning, photo)));
  }
}
