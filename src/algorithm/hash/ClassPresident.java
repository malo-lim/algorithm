package algorithm.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClassPresident {

  public char solution(int n, String s) {
    char answer = 'A';
    int max = 0;
    Map<Character, Integer> map = new HashMap<>();

    for (char c: s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0).intValue() + 1);
    }

    for (char key: map.keySet()) {
      if (map.get(key) > max) {
        max = map.get(key);
        answer = key;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    ClassPresident main = new ClassPresident();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    String s = scanner.next();

    System.out.println(main.solution(n, s));
  }
}
