package algorithm.stack;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {

    public int solution(String s) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - 48);
            } else {
                int rt = stack.pop();
                int lt = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(lt + rt);
                        break;
                    case '-':
                        stack.push(lt - rt);
                        break;
                    case '*':
                        stack.push(lt * rt);
                        break;
                    case '/':
                        stack.push(lt / rt);
                        break;
                }

            }
        }

        answer = stack.get(0);

        return answer;
    }

    public static void main(String[] args) {
        Postfix main = new Postfix();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        System.out.println(main.solution(s));
    }
}
