package algorithm.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {

  public String solution(String s1, String s2) {
    String answer = "YES";
    Map<Character, Integer> map = new HashMap<>();

    for (char c: s1.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for (char c: s2.toCharArray()) {
      if (!map.containsKey(c) || map.get(c) == 0) {
        return "NO";
      }

      map.put(c, map.get(c)-1);

    }

    return answer;
  }

  public static void main(String[] args) {
    Anagram main = new Anagram();
    Scanner scanner = new Scanner(System.in);
    String s1 = scanner.next();
    String s2 = scanner.next();

    System.out.println(main.solution(s1, s2));

  }
}
