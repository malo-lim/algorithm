package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P87377_교점에_별_만들기 {

  // 좌표 나타내는 클래스
  private static final class Point {
    public final long x, y;

    private Point(long x, long y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) {
    /*
    문제풀이
    1. 모든 직선 쌍에 대해 반복
      A. 교점 좌표 구하기
      B. 정수 좌표만 저장
    2. 저장된 정수들에 대해 x, y 좌표의 최댓값, 최솟값 구하기
    3. 구한 최댓값, 최솟값을 이용하여 2차원 배열의 크기 결정
    4. 2차원 배열에 별 표시
    5. 문자열 배열로 변환 후 반환
     */

  }

  public String[] solution(int[][] line) {
    List<Point> points = new ArrayList<>();
    for (int i = 0; i < line.length; i++) {
      for (int j = i + 1; j < line.length; j++) {
        Point intersection = intersection(line[i][0], line[i][1],line[i][2],
            line[j][0], line[j][1], line[j][2]);

        if (intersection != null) {
          points.add(intersection);
        }

      }
    }

    Point minimum = getMinumumPoint(points);
    Point maximum = getMaximumPoint(points);

    int width = (int) (maximum.x - minimum.x + 1);
    int height = (int) (maximum.y - minimum.y + 1);

    char[][] arr = new char[height][width];
    for (char[] row: arr) {
      Arrays.fill(row, '.');
    }

    for (Point p: points) {
      int x = (int) (p.x - minimum.x);
      int y = (int) (maximum.y - p.y);
      arr[y][x] = '*';
    }

    String[] result = new String[arr.length];
    for (int i = 0; i < result.length; i++) {
      result[i] = new String(arr[i]);
    }

    return result;
  }

  // 교점 좌표 구하기
  private Point intersection(long a1, long b1, long c1,
                             long a2, long b2, long c2) {
    // 교점 구해서 반환하기
    double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
    double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

    if (x % 1 != 0 || y % 1 != 0) {
      return null;
    }

    return new Point((long) x, (long) y);
  }

  private Point getMinumumPoint(List<Point> points) {
    long x = Long.MAX_VALUE;
    long y = Long.MAX_VALUE;

    for (Point p: points) {
      if (p.x < x) {
        x = p.x;
      }
      if (p.y < y) {
        y = p.y;
      }
    }

    return new Point(x, y);
  }

  private Point getMaximumPoint(List<Point> points) {
    long x = Long.MIN_VALUE;
    long y = Long.MIN_VALUE;

    for (Point p: points) {
      if (p.x > x) {
        x = p.x;
      }
      if (p.y > y) {
        y = p.y;
      }
    }

    return new Point(x, y);
  }
}
