package algorithm.old.string;

import java.util.Scanner;

public class Cipher {
  public String getString(int n, String s) {
    StringBuilder answer = new StringBuilder();
    String temp = "";

    for (int i=0; i<n; i++) {
      temp = s.substring(0, 7).replaceAll("#", "1").replaceAll("\\*", "0");
      answer.append((char) Integer.parseInt(temp, 2));
      s = s.substring(7);
    }

    return answer.toString();
  }

  public static void main(String[] args) {
    Cipher main = new Cipher();
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    String s = scanner.next();

    System.out.println(main.getString(n, s));
  }

}
