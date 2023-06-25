package algorithm.old.array;

import java.util.Scanner;

public class TallStudent {

    public int solution(int[] student) {
        int count = 1;
        int max = student[0];

        for (int i=1; i<student.length; i++) {
            if (student[i] > max) {
                max = student[i];
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        TallStudent main = new TallStudent();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] student = new int[n];

        for (int i=0; i<n; i++) {
            student[i] = scanner.nextInt();
        }

        System.out.println(main.solution(student));
    }
}
