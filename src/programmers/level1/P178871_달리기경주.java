package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P178871_달리기경주 {

  private static String[] solution(String[] players, String[] callings) {
    Map<String, Integer> playerMap = new HashMap<>();

    for (int i = 0; i < players.length; i++) {
      playerMap.put(players[i], i); // 각 플레이어의 인덱스 저장
    }

    for (String calling : callings) {
      // 이름 불린 플레이어의 인덱스를 얻어온다.
      int idx = playerMap.get(calling);

      if (idx > 0) {
        // 스왑 진행
        String temp = players[idx - 1];
        players[idx - 1] = players[idx];
        players[idx] = temp;

        // 맵도 같이 스왑해준다.
        playerMap.put(players[idx - 1], idx - 1);
        playerMap.put(players[idx], idx);
      }
    }

    return players;
  }

  public static void main(String[] args) {
    String[] players = {"mumu", "soe", "poe", "kai", "mine"};
    String[] callings = {"kai", "kai", "mine", "mine"};

    System.out.println(Arrays.toString(solution(players, callings)));
  }
}
