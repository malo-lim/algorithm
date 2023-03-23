package algorithm.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MeetingRoom {

  private static class Meeting implements Comparable<Meeting> {
    int startTime, endTime;

    public Meeting(int startTime, int endTime) {
      this.startTime = startTime;
      this.endTime = endTime;
    }

    @Override
    public int compareTo(Meeting o) {
      if (o.endTime == this.endTime) {
        return this.startTime - o.startTime;
      } else {
        return this.endTime - o.endTime;
      }
    }
  }

  private int solution(List<Meeting> list) {
    int answer = 0;
    int endTime = 0;
    Collections.sort(list);

    for (Meeting meeting: list) {
      if (meeting.startTime >= endTime) {
        answer++;
        endTime = meeting.endTime;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    MeetingRoom main = new MeetingRoom();
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<Meeting> list = new ArrayList<>();

    for (int i=0; i<n; i++) {
      int startTime = scanner.nextInt();
      int endTime = scanner.nextInt();

      list.add(new Meeting(startTime, endTime));
    }

    System.out.println(main.solution(list));
  }
}
