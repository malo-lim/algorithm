package algorithm.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {

  public List<Long> solution(int n) {
    List<Long> list = new ArrayList<>(n);
    list.add(1L);
    list.add(1L);
    list.add(2L);

    for (int i=3; i<n; i++) {
      list.add(list.get(i-2) + list.get(i-1));
    }

    return list;
  }

  public static void main(String[] args) {
    Fibonacci main = new Fibonacci();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    for (Long number: main.solution(n)) {
      System.out.print(number + " ");
    }

  }
}
