package algorithm.old.stack;

import java.util.Scanner;
import java.util.Stack;

public class RemoveParenthesesCharacters {

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if (c == ')') {
                while (stack.pop() != '(');
            } else {
                stack.push(c);
            }
        }

        for (char c: stack) {
            answer.append(c);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        RemoveParenthesesCharacters main = new RemoveParenthesesCharacters();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        System.out.println(main.solution(s));
    }
}
