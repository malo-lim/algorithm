package practice.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1543_문서검색 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String doc = br.readLine();
    String word = br.readLine();
    int answer = 0;

    for (int i = 0, docSize=doc.length(); i < docSize; i++) {
      boolean isMatch = true;
      for (int j = 0, wordSize=word.length(); j < wordSize; j++) {
        // 길이 체크하고, 한글자씩 비교해서 맞지 않다면 false
        if (i + j >= doc.length() ||
            doc.charAt(i + j) != word.charAt(j)) {
          isMatch = false;
          break;
        }
      }

      if(isMatch) {
        answer++;
        i += word.length() - 1;
      }
    }
    System.out.println(answer);
  }
}
