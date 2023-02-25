package algorithm.string;

import java.util.Locale;
import java.util.Scanner;

public class Palindrome {

    public String palindrome1(String s) {
        String answer = "YES";
        s = s.toLowerCase(Locale.ROOT);
        int length = s.length();

        for (int i=0; i<length/2; i++) {
            if (s.charAt(i) != s.charAt(length-i-1)) {
                answer = "NO";
                break;
            }
        }

        return answer;
    }

    public String palindrome2(String s) {
        String answer = "YES";
        String temp = new StringBuilder(s).reverse().toString();

        if (!s.equalsIgnoreCase(temp)) {
            answer = "NO";
        }

        return answer;
    }

    public String palindromeReplaceAll(String s) {
        String answer = "YES";
        s = s.toLowerCase(Locale.ROOT).replaceAll("[^A-Za-z]", "");
        String temp = new StringBuilder(s).reverse().toString();

        if (!s.equals(temp)) {
            answer = "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        Palindrome main = new Palindrome();

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(main.palindrome1(s));
        System.out.println(main.palindrome2(s));
        System.out.println(main.palindromeReplaceAll(s));
    }
}
