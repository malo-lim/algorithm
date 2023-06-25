package algorithm.old.set;

import java.util.*;

public class MaxNumberK {

    public int solution(int n, int k, int[] arr) {
        int answer = -1;
        int count = 1;

        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                for (int l=j+1; l<n; l++) {
                    set.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }

        for (int value: set) {
            if (count == k) {
                return value;
            }
            count++;
        }

        return answer;
    }

    public static void main(String[] args) {
        MaxNumberK main = new MaxNumberK();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(main.solution(n, k, arr));
    }
}
