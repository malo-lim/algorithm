package recent.algorithm.greedy;

import java.util.*;

public class WarGame {

  private static class Student implements Comparable<Student> {
    int number;
    char team;
    int power;

    public Student(int number, char team, int power) {
      this.number = number;
      this.team = team;
      this.power = power;
    }

    @Override
    public int compareTo(Student o) {
      return this.power - o.power;
    }

    @Override
    public String toString() {
      return "Student{" +
          "number=" + number +
          ", team=" + team +
          ", power=" + power +
          '}';
    }
  }

  private int[] solution(String[] students) {
    int n = students.length;
    int[] answer = new int[n];

    List<Student> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String[] split = students[i].split(" ");
      Student student = new Student(i, split[0].charAt(0), Integer.parseInt(split[1]));
      list.add(student);
    }

    Map<Character, Integer> map = new HashMap<>();
    int total = 0, j = 0;

    Collections.sort(list);

    // i 값과 j값을 비교하기 위해 진행
    for (int i = 1; i < n; i++) {
      for (; j < n; j++) {
        /*
         1. 현재 값이 이전 값보다 더 크다면, 이전 값을 total에 더해준다.
         2. map에 team에 power를 더해준다.
         */
        if (list.get(j).power < list.get(i).power) {
          char team = list.get(j).team;
          int power = list.get(j).power;

          total += power;
          map.put(team, map.getOrDefault(team, 0) + power);
        } else {
          break;
        }
      }
      // answer에 total에서 map에 들어있는 팀의 power를 빼준다.
      int number = list.get(i).number;
      char team = list.get(i).team;
      answer[number] = total - map.getOrDefault(team, 0);
    }

    return answer;
  }

  public static void main(String[] args) {
    WarGame main = new WarGame();
    System.out.println(Arrays.toString(main.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
    System.out.println(Arrays.toString(main.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
    System.out.println(Arrays.toString(main.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
    System.out.println(Arrays.toString(main.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
  }
}
