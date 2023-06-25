package algorithm.old.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SavePrincess {

    public int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i=1; i<=n; i++) {
            queue.offer(i);
        }

        while (queue.size() != 1) {
            for (int i=0; i<k-1; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }

        answer = queue.poll();

        return answer;
    }

    public static void main(String[] args) {
        SavePrincess main = new SavePrincess();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(main.solution(n, k));
    }
}
