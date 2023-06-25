package algorithm.old.stack;

import java.util.Scanner;
import java.util.Stack;

public class CorrectParentheses {

    public String solution(String s) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if ('(' == c) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            return "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        CorrectParentheses main = new CorrectParentheses();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        System.out.println(main.solution(s));
    }
}
