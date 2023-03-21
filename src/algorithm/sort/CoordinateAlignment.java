package algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CoordinateAlignment {

  private static class Point implements Comparable<Point> {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Point point) {
      /*
       정렬은 일단 음수가 나오도록 하기.
       밑의 값은 오름차순 정렬 방식이고
       내림차순이 되려면 point.y - this.y, point.x - this.x가 되어야 한다.
       */
      if (this.x == point.x) {
        return this.y - point.y;
      } else {
        return this.x - point.x;
      }
    }
  }

  public static void main(String[] args) {
    CoordinateAlignment main = new CoordinateAlignment();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<Point> list = new ArrayList<>();
    int x, y;


    for (int i=0; i<n; i++) {
      x = scanner.nextInt();
      y = scanner.nextInt();
      list.add(new Point(x, y));
    }

    Collections.sort(list);

    for (Point p: list) {
      System.out.println(p.x + " " + p.y);
    }

  }
}
