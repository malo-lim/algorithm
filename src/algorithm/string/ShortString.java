package algorithm.string;

import java.util.Scanner;

public class ShortString {

    /**
     설명
     한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.

     입력
     첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
     문자열의 길이는 100을 넘지 않는다.

     출력
     첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.

     예시 입력 1
     teachermode e

     예시 출력 1
     1 0 1 2 1 0 1 2 2 1 0
     */
    public int[] shortString(String s, char t) {
        int min = 100;
        int[] answer = new int[s.length()];

        for (int i=0, size=s.length(); i<size; i++) {
            if (s.charAt(i) == t) {
                min = 0;
            } else {
                min++;
            }
            answer[i] = min;
        }

        min = 100;
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) == t) {
                min = 0;
            } else {
                min++;
                answer[i] = Math.min(answer[i], min);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        ShortString main = new ShortString();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char t = scanner.next().charAt(0);

        for (int x: main.shortString(s, t)) {
            System.out.print(x + " ");
        }
    }
}
