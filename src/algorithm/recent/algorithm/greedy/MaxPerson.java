package algorithm.recent.algorithm.greedy;

import java.util.Arrays;

public class MaxPerson {

  private int solution(int n, int[][] trains, int[][] bookings) {
    int answer = 0;
    int[] sum = new int[n + 1];

    // 시작시점에 몇명이 탈 수 있는지 더해주고,
    // 도착지점에 몇명이 탈 수 있는지 빼준다.
    for (int i = 0; i < trains.length; i++) {
      sum[trains[i][0]] += trains[i][2];
      sum[trains[i][1]] -= trains[i][2];
    }

    // 
    for (int i = 1; i <= n; i++) {
      sum[i] += sum[i-1];
    }

    System.out.println(Arrays.toString(sum));

    return answer;
  }

  public static void main(String[] args) {
    MaxPerson main = new MaxPerson();
    System.out.println(main.solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 5}, {2, 4}, {2, 5},{2, 3}, {3, 5}, {3, 4}}));
    System.out.println(main.solution(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}}));
    System.out.println(main.solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
    System.out.println(main.solution(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}}));
    System.out.println(main.solution(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}}));
  }
}
