package algorithm.old.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AllAnagram {

    public int solution(String s, String t) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (char c: t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int lt = 0;
        int L = t.length()-1;
        for (int i=0; i < L; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int rt = L; rt<s.length(); rt++) {
            map.put(s.charAt(rt), map.getOrDefault(s.charAt(rt), 0) + 1);

            if (tMap.equals(map)) {
                answer++;
            }

            map.put(s.charAt(lt), map.get(s.charAt(lt)) - 1);
            if (map.get(s.charAt(lt)) == 0) {
                map.remove(s.charAt(lt));
            }
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        AllAnagram main = new AllAnagram();
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();

        System.out.println(main.solution(s1, s2));
    }
}
