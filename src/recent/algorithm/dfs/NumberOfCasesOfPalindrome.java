package recent.algorithm.dfs;

import java.util.*;

public class NumberOfCasesOfPalindrome {

  Deque<Character> deque;
  Map<Character, Integer> frequency;
  List<String> result;
  int length;

  private void dfs() {
    if (deque.size() == length) {
      StringBuilder temp = new StringBuilder();
      for (char c: deque) {
        temp.append(c);
      }
      result.add(temp.toString());
    } else {
      for (char key: frequency.keySet()) {
        if (frequency.get(key) == 0) {
          continue;
        }

        deque.addFirst(key);
        deque.addLast(key);
        frequency.put(key, frequency.get(key) - 2);

        dfs();

        deque.pollFirst();
        deque.pollLast();
        frequency.put(key, frequency.get(key) + 2);
      }
    }
  }

  private String[] solution(String s) {

    /*
    1. 해당 문자의 빈도수를 넣어준다.
    2. 홀수인 문자의 개수를 세어준다.
      - 홀수의 문자의 개수가 2개이상이면 해당 문자열은 팰린드롬을 만들 수 없다. (즉, 빈값 리턴)
    3. 홀수의 문자가 1개라면 deque에 넣어주고, 빈도수 변수에서 해당 값을 한개 빼 준다.
    4. dfs 시작
      1) deque 길이가 문자열(s)의 길이와 동일하다면 팰린드롬 이므로, 문자열로 만들어서 result 리스트에 추가한다.
      2) 길이가 동일하지 않다면 빈도수 변수에 0이 아닌걸 찾아서 deque에 앞뒤로 하나씩 넣어주고, 빈도수에서 2개 빼준다.
      3) dfs 다시 시작 (즉, deque에서 앞뒤로 빼주고, 빈도수에서 2개씩 추가해준다.
     */

    deque = new LinkedList<>();
    result = new ArrayList<>();
    frequency = new HashMap<>();
    length = s.length();

    // 빈도수를 넣어준다.
    for (char key: s.toCharArray()) {
      frequency.put(key, frequency.getOrDefault(key, 0) + 1);
    }

    int odd = 0;
    char mid = '#';

    // 빈도수에서 홀수인 문자의 개수를 찾아서 1개의 경우엔 중간값에 key를 넣어준다.
    for (char key: frequency.keySet()) {
      if (frequency.get(key) % 2 == 1) {
        mid = key;
        odd++;
      }
    }

    if (odd > 1) {
      return new String[]{};
    }

    // 중간 값이 있으므로 deque에 넣어주고, 빈도수 변수에서 해당 값을 한개 빼 준다.
    if (mid != '#') {
      deque.add(mid);
      frequency.put(mid, frequency.get(mid) - 1);
    }

    dfs();

    return result.toArray(new String[result.size()]);
  }

  public static void main(String[] args) {
    NumberOfCasesOfPalindrome main = new NumberOfCasesOfPalindrome();
    System.out.println(Arrays.toString(main.solution("aaaabb")));
    System.out.println(Arrays.toString(main.solution("abbcc")));
    System.out.println(Arrays.toString(main.solution("abbccee")));
    System.out.println(Arrays.toString(main.solution("abbcceee")));
    System.out.println(Arrays.toString(main.solution("ffeffaae")));
  }
}
