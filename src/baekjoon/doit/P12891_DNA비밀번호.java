package baekjoon.doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P12891_DNA비밀번호 {

  private static final Map<Character, Integer> map = new HashMap<>();
  private static final int[] check = new int[4];
  private static final int[] myArr = new int[4];
  private static int count = 0;

  public static void main(String[] args) throws IOException {
    // 슬라이딩 윈도우 문제
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int S = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());
    int result = 0; // 결과
    char[] ch = new char[S]; // 데이터 받을 변수

    ch = br.readLine().toCharArray();
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < 4; i++) {
      check[i] = Integer.parseInt(st.nextToken());

      // check 개수가 0이면 count를 증가시킨다.
      if (check[i] == 0) {
        count++;
      }
    }

    addMap();
    for (int i = 0; i < P; i++) { // 부분 문자열 처음 받을때 세팅
      add(ch[i]);
    }

    if (count == 4) {
      result++;
    }

    // 슬라이딩 윈도우 시작
    // i는 맨끝, j는 맨앞
    for (int i = P; i < S; i++) {
      int j = i - P;
      add(ch[i]);
      remove(ch[j]);
      if (count == 4) {
        result++;
      }
    }

    System.out.println(result);
    br.close();

  }

  private static void addMap() {
    map.put('A', 0);
    map.put('C', 1);
    map.put('G', 2);
    map.put('T', 3);
  }

  private static void add(char c) {
    int index = map.get(c);
    myArr[index]++;
    if (myArr[index] == check[index]) {
      count++;
    }
  }

  private static void remove(char c) {
    int index = map.get(c);
    if (myArr[index] == check[index]) {
      count--;
    }
    myArr[index]--;
  }
}

