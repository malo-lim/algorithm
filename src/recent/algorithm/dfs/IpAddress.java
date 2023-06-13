package recent.algorithm.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IpAddress {

  LinkedList<String> list;
  List<String> result;

  private void dfs(int start, String s) {
    // IP 주소의 4개 즉 ([123, 123, 123, 123])형태로 4개이면서, start(index)가 s의 길이와 같다면 답이 있는것.
    if (list.size() == 4 && start == s.length()) {
      String r = "";

      for (String x: list) {
        r += x + ".";
      }

      result.add(r.substring(0, r.length() - 1));

    } else {
      int length = s.length();
      // 조합의 경우를 만든다.
      // 즉 가지치기를 하는..
      for (int i = start; i < length; i++) {
        // 값이 0으로 시작하면서 2자리 이상이면 return
        if (s.charAt(start) == '0' && i > start) {
          return;
        }

        // 조합하여 Number를 만든다.
        String num = s.substring(start, i + 1);

        // 조합한 숫자가 255(즉 아이피 범위를 초과한다면 return)
        if (Integer.parseInt(num) > 255) {
          return;
        }

        // 그게 아니라면 Num을 넣어준다.
        list.add(num);

        // dfs 다음꺼 진행
        dfs(i + 1, s);

        // 그리고 뒤에껄 꺼내어서 시작할 수 있게 마지막꺼 poll하기
        list.pollLast();

      }
    }
  }

  private String[] solution(String s) {

    list = new LinkedList<>();
    result = new ArrayList<>();

    dfs(0, s);

    int size = result.size();
    String[] answer = new String[size];

    for (int i = 0; i < size; i++) {
      answer[i] = result.get(i);
    }

    return answer;
  }

  public static void main(String[] args) {
    IpAddress main = new IpAddress();
    System.out.println(Arrays.toString(main.solution("2025505")));
    System.out.println(Arrays.toString(main.solution("0000")));
    System.out.println(Arrays.toString(main.solution("255003")));
    System.out.println(Arrays.toString(main.solution("155032012")));
    System.out.println(Arrays.toString(main.solution("02325123")));
    System.out.println(Arrays.toString(main.solution("121431211")));
  }

}
