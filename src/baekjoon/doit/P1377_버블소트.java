package baekjoon.doit;

import java.io.*;
import java.util.Arrays;

public class P1377_버블소트 {

  private static final class Data implements Comparable<Data> {
    int value;
    int index;

    public Data(int value, int index) {
      super();
      this.value = value;
      this.index = index;
    }

    @Override
    public int compareTo(Data o) {
      // value 를 기준으로 오름차순
      // 내림차순은 o.value - this.value;
      return this.value - o.value;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    Data[] arr = new Data[N];

    for (int i = 0; i < N; i++) {
      arr[i] = new Data(Integer.parseInt(br.readLine()), i);
    }

    // O(nlogn)의 시간 복잡도를 가진 정렬 알고리즘을 이용하여 정렬한다.
    Arrays.sort(arr);
    int max = 0;

    // index가 몇번 움직였는지 확인한다.
    for (int i = 0; i < N; i++) {
      max = Math.max(max, arr[i].index - i);
    }

    bw.write(String.valueOf(max + 1));
    bw.close();
    br.close();

  }
}
