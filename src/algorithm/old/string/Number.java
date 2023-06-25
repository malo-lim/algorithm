package algorithm.old.string;

import java.util.Scanner;

public class Number {

    public int getNumberSum(String s) {
        int answer = 0;

        for (char c: s.toCharArray()) {
            if (c >= 48 && c <= 57) {
                // 계산식
                answer = answer * 10 + (c - 48);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Number main = new Number();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        System.out.println(main.getNumberSum(s));
    }
}
