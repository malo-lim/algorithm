package algorithm.string;

import java.util.Scanner;

public class ToCase {
    public String change(String s) {
        char[] array = new char[s.length()];
        char c;

        for (int i=0; i<s.length(); i++) {
            c = s.charAt(i);
            if (c >= 97 && c <= 122) {
                array[i] = (char) (c - 32);
            } else {
                array[i] = (char) (c + 32);
            }
        }

        return String.valueOf(array);
    }

    public static void main(String[] args) {
        ToCase main = new ToCase();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(main.change(s));
    }

}
