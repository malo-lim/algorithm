package algorithm.string;

import java.util.Scanner;

public class StringCompression {

    public String compress(String s) {
        StringBuilder answer = new StringBuilder();
        int count = 1;

        for (int i=0, size=s.length()-1; i<size; i++) {
            if (s.charAt(i) != s.charAt(i+1)) {
                answer.append(s.charAt(i));

                if (count > 1) {
                    answer.append(count);
                }

                count = 1;
            } else {
                count++;
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        StringCompression main = new StringCompression();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next() + " ";

        System.out.println(main.compress(s));
    }
}
