package practice.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1919_애너그램_만들기 {
  private static int[] getCharacterCount(String s) {
    int[] count = new int[26];

    for (int i = 0, size=s.length(); i < size; i++) {
      count[s.charAt(i) - 'a']++;
    }

    return count;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String A = br.readLine();
    String B = br.readLine();
    int result = 0;

    int[] countA = getCharacterCount(A);
    int[] countB = getCharacterCount(B);

    for (int i = 0; i < countA.length; i++) {
      result += Math.abs(countA[i] - countB[i]);
    }

    System.out.println(result);
  }
}
