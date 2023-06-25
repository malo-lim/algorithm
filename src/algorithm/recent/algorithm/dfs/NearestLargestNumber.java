package algorithm.recent.algorithm.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NearestLargestNumber {

  int answer, MAX_LEVEL, target;
  boolean isFind;
  boolean[] isVisited;
  List<Integer> list;

  private void dfs(int level, int num) {

    if (isFind) {
      return;
    }

    if (level == MAX_LEVEL) {
      if (num > target) {
        answer = num;
        isFind = true;
      }
    } else {

      for (int i = 0; i < MAX_LEVEL; i++) {
        if (!isVisited[i]) {
          isVisited[i] = true;
          dfs(level + 1, num * 10 + list.get(i));
          isVisited[i] = false;
        }
      }

    }

  }

  private int solution(int n) {
    answer = 0;
    target = n;
    isFind = false;

    list = new ArrayList<>();
    int temp = n;

    while (temp > 0) {
      list.add(temp % 10);
      temp = temp / 10;
    }

    Collections.sort(list);
    MAX_LEVEL = list.size();
    isVisited = new boolean[MAX_LEVEL];

    dfs(0, 0);

    if (!isFind) {
      return -1;
    }

    return answer;
  }

  public static void main(String[] args) {
    NearestLargestNumber main = new NearestLargestNumber();
    System.out.println(main.solution(123));
    System.out.println(main.solution(321));
    System.out.println(main.solution(20573));
    System.out.println(main.solution(27711));
    System.out.println(main.solution(54312));
  }
}
