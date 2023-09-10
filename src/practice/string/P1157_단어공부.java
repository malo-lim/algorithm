package practice.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1157_단어공부 {
  private static int[] getCharacterCount(String s) {
    int[] count = new int[26];

    // 대문자로 출력하기 때문에, 개수를 세주면 된다.
    for (char c : s.toCharArray()) {
      if (c >= 'A' && c <= 'Z') {
        count[c - 'A']++;
      } else {
        count[c - 'a']++;
      }
    }

    return count;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String read = br.readLine();

    int[] count = getCharacterCount(read);
    int maxCount = -1;
    char result = '?';

    for (int i = 0; i < count.length; i++) {
      if (count[i] > maxCount) {
        maxCount = count[i];
        result = (char) (i + 'A');
      } else if (count[i] == maxCount) {
        result = '?';
      }
    }

    System.out.println(result);
  }
}
