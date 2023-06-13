package recent.algorithm.dfs;

public class AlphaCode {

  int[] dy;

  private int dfs(int start, String s) {
    // 이미 값이 구해져 있다면 return
    if (dy[start] > 0) {
      return dy[start];
    }

    // 문자열이 끝까지 안갔고, 0으로 시작하는경우 복원할 수없으므로 0
    if (start < s.length() && s.charAt(start) == '0') {
      return 0;
    }

    // 마지막 인덱스 숫자이거나, 아예 마지막 길이를 벗어난다면 경우의 수는 1가지이므로 1 return
    if (start == s.length() - 1 || start == s.length()) {
      return 1;
    } else {
      int res = dfs(start + 1, s); // 첫번째의 값
      int temp = Integer.parseInt(s.substring(start, start + 2)); // 두번째의 값

      if (temp <= 26) {
        res += dfs(start + 2, s);
      }

      return dy[start] = res;
    }
  }

  private int solution(String s) {
    dy = new int[101];
    return dfs(0, s);
  }

  public static void main(String[] args) {
    AlphaCode main = new AlphaCode();
    System.out.println(main.solution("25114"));
    System.out.println(main.solution("23251232"));
    System.out.println(main.solution("21020132"));
    System.out.println(main.solution("21350"));
    System.out.println(main.solution("120225"));
    System.out.println(main.solution("232012521"));
  }
}
