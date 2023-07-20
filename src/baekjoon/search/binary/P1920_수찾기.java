package baekjoon.search.binary;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920_수찾기 {

  static int[] nums;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    nums = new int[N];

    StringTokenizer token = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(token.nextToken());
    }

    // 이진 탐색을 위해 정렬을 해준다.
    Arrays.sort(nums);

    int M = Integer.parseInt(br.readLine());
    token = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int target = Integer.parseInt(token.nextToken());
      bw.write(Integer.toString(binarySearch(target)));
      bw.newLine();
    }

    bw.close();
  }

  private static int binarySearch(int target) {
    /*
    이진 탐색 설명
    1. 시작, 끝 인덱스를 0, 배열길이 -1로 초기화
    2. 반복문을 돌리는데, 시작 인덱스가 마지막 인덱스보다 작거나 같은경우까지 돌린다.
    3. 중간값을 구해서 중간의 값이 타겟값과 비교한다.
     1) 중간 인덱스 값 공식 : (start + end) / 2
     2) 타겟의 값이 크면 마지막 인덱스에 중간 인덱스 -1 한값을 넣어준다.
     3) 타겟의 값이 작다면 시작 인덱스에 중가 인덱스 +1 한값을 넣어준다.
     4) 동일하면 종료한다.
     */
    int start = 0;
    int end = nums.length - 1;

    while (start <= end) {
      int mid = (start + end) / 2;

      if (nums[mid] > target) {
        end = mid - 1;
      } else if (nums[mid] < target) {
        start = mid + 1;
      } else {
        return 1;
      }
    }

    return 0;
  }

}
