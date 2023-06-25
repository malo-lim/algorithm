package algorithm.old.stack;

import java.util.Scanner;
import java.util.Stack;

public class IronStick {

    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i=0, size=s.length(); i<size; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();

                if (s.charAt(i-1) == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        IronStick main = new IronStick();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        System.out.println(main.solution(s));
    }
}
