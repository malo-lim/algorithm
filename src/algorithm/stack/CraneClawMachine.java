package algorithm.stack;

import java.util.Scanner;
import java.util.Stack;

public class CraneClawMachine {

    public int solution(int n, int[][] board, int[] moves) {
        int answer = 0;
        int move = 0;
        Stack<Integer> stack = new Stack<>();

        for (int pos: moves) {
            for (int i=0; i<n; i++) {
                move = board[i][pos-1];
                if (move != 0) {
                    board[i][pos-1] = 0;
                    if (!stack.isEmpty() && stack.peek() == move) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(move);
                    }
                    break;
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        CraneClawMachine main = new CraneClawMachine();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] board = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        int m = scanner.nextInt();
        int[] moves = new int[m];

        for (int i=0; i<m; i++) {
            moves[i] = scanner.nextInt();
        }

        System.out.println(main.solution(n, board, moves));
    }
}
