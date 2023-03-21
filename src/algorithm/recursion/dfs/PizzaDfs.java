package algorithm.recursion.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PizzaDfs {

  private static class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  static int n, m, length, answer = Integer.MAX_VALUE;
  static int[] combination;
  static List<Point> pizza, house;

  private void dfs(int level, int s) {
    if (level == m) {
      // 피자 배달 거리 구하기
      int sum = 0;
      for (Point h: house) {
        int dis = Integer.MAX_VALUE;
        for (int i: combination) {
          dis = Math.min(dis, Math.abs(h.x - pizza.get(i).x) + Math.abs(h.y - pizza.get(i).y));
        }
        sum += dis;
      }
      answer = Math.min(answer, sum);
    } else {
      // 조합은 이러한 형태로.. 외우기
      for (int i=s; i<length; i++) {
        combination[level] = i;
        dfs(level+1, i+1);
      }
    }
  }

  public static void main(String[] args) {
    PizzaDfs main = new PizzaDfs();
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    m = scanner.nextInt();
    pizza = new ArrayList<>();
    house = new ArrayList<>();

    for (int i=0; i<n; i++) {
      for (int j=0; j<n; j++) {
        int temp = scanner.nextInt();
        if (temp == 1) {
          house.add(new Point(i, j));
        } else if (temp == 2) {
          pizza.add(new Point(i, j));
        }
      }
    }

    length = pizza.size();
    combination = new int[m];

    main.dfs(0, 0);
    System.out.println(answer);
  }
}
