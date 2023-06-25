package algorithm.recent.algorithm.simulation;

import java.util.Scanner;

public class LostDog {

  public int solution(int[][] board, int[] human, int[] dog) {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    int d1 = 0; // 인간
    int d2 = 0; // 개

    int hx = human[0];
    int hy = human[1];

    int dox = dog[0];
    int doy = dog[1];

    int answer = 0;

    while (answer < 10000) {
      answer++;

      int nx1 = hx + dx[d1];
      int ny1 = hy + dy[d1];

      int nx2 = dox + dx[d2];
      int ny2 = doy + dy[d2];

      boolean isNotHumanRotation = true;
      boolean isNotDogRotation = true;

      //System.out.println(nx1 + ", " + ny1 + " / " + nx2 + ", " + ny2);

      if (nx1 >= 10 || ny1 >= 10 || nx1 < 0 || ny1 < 0 || board[nx1][ny1] == 1) {
        d1 = (d1 + 1) % 4;
        isNotHumanRotation = false;
      }

      if (nx2 >= 10 || ny2 >= 10 || nx2 < 0 || ny2 < 0 || board[nx2][ny2] == 1) {
        d2 = (d2 + 1) % 4;
        isNotDogRotation = false;
      }

      if (isNotHumanRotation) {
        hx = nx1;
        hy = ny1;
      }

      if (isNotDogRotation) {
        dox = nx2;
        doy = ny2;
      }

      if (hx == dox && hy == doy) {
        break;
      }
    }

    return (answer >= 10000) ? 0 : answer;
  }

  public static void main(String[] args) {
    LostDog main = new LostDog();
    Scanner scanner = new Scanner(System.in);
    int[][] board = new int[10][10];
    int[] human = new int[2];
    int[] dog = new int[2];
    
    /*
    ###################
    0 0 0 0 0 0 1 0 0 0
    0 0 0 0 1 0 0 0 0 0
    0 0 0 1 0 0 0 1 0 0
    0 0 0 0 0 0 0 0 0 0
    0 0 0 1 0 0 0 2 0 0
    1 0 0 0 0 0 1 0 0 0
    0 0 0 1 0 0 0 0 0 0
    0 0 0 0 0 3 0 0 0 1
    0 0 0 1 0 1 0 0 0 0
    0 1 0 1 0 0 0 0 0 0
    ###################
    ###################
    1 0 0 0 1 0 0 0 0 0
    0 0 0 0 0 0 1 0 0 0
    0 0 1 1 0 0 0 1 0 0
    0 0 0 0 0 0 0 0 0 0
    0 0 0 1 0 1 0 0 0 0
    1 0 0 0 0 0 1 0 1 0
    0 0 0 1 0 0 0 0 0 0
    0 0 1 0 0 0 0 0 2 1
    0 0 0 1 0 1 0 0 0 1
    0 1 0 1 0 0 0 0 0 3
    ###################
    
     */
    
    for (int i=0; i<10; i++) {
      for (int j=0; j<10; j++) {
        int n = scanner.nextInt();
        board[i][j] = n;
        if (n == 2) {
          human[0] = i;
          human[1] = j;
        } else if (n == 3) {
          dog[0] = i;
          dog[1] = j;
        }
      }
    }

    System.out.println(main.solution(board, human, dog));

  }
}
