package algorithm.recent.algorithm.simulation;

public class TakeFruit {

  public int getMin(int[] fruit) {
    int min = 100;

    for (int x: fruit) {
      min = Math.min(min, x);
    }

    return min;
  }

  public boolean isMinUnique(int[] fruit) {
    int count = 0;
    int min = getMin(fruit);

    for (int x: fruit) {
      if (x == min) {
        count++;
      }
    }

    return count == 1;
  }

  public int getMinIndex(int[] fruit) {
    int min = getMin(fruit);

    for (int i=0; i<3; i++) {
      if (fruit[i] == min) {
        return i;
      }
    }

    return 0;
  }

  public int solution(int[][] fruit) {
    int answer = 0;
    int n = fruit.length;
    boolean[] isTrade = new boolean[n];

    for (int i = 0; i < n; i++){
      if (isTrade[i]) {
        continue;
      }

      if (!isMinUnique(fruit[i])) {
        continue;
      }

      for (int j = i+1; j < n; j++) {
        if (isTrade[j]) {
          continue;
        }

        if (!isMinUnique(fruit[j])) {
          continue;
        }

        int a = getMinIndex(fruit[i]);
        int b = getMinIndex(fruit[j]);
        if (a != b && fruit[i][b] > 0 && fruit[j][a] > 0) {
          if (fruit[i][a] + 1 <= fruit[i][b] - 1 && fruit[j][b] + 1 <= fruit[j][a] - 1) {
            fruit[i][a]++;
            fruit[i][b]--;
            fruit[j][b]++;
            fruit[j][a]--;
            isTrade[i] = true;
            isTrade[j] = true;
            break;
          }
        }
      }
    }

    for (int[] x : fruit) {
      answer += getMin(x);
    }
    return answer;
  }

  public static void main(String[] args) {
    TakeFruit main = new TakeFruit();
    System.out.println(main.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10},{10, 15, 10}}));


  }
}
