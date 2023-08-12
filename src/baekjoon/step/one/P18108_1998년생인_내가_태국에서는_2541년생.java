package baekjoon.step.one;

import java.util.Scanner;

public class P18108_1998년생인_내가_태국에서는_2541년생 {

  private static int toAdYear(int bcYear) {
    // 서기년도는 불기년도에 544를 빼면 된다 (한국은 + 1을 해준다.)
    return bcYear - 544 + 1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int bcYear = sc.nextInt();
    System.out.println(toAdYear(bcYear));
  }
}
