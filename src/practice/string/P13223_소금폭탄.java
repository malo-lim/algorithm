package practice.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P13223_소금폭탄 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String currentTime = br.readLine();
    String dropTime = br.readLine();

    String[] current = currentTime.split(":");
    int currentHour = Integer.parseInt(current[0]);
    int currentMinute = Integer.parseInt(current[1]);
    int currentSecond = Integer.parseInt(current[2]);
    int currentSecondAmount = currentHour * 3600 + currentMinute * 60 + currentSecond;

    String[] drop = dropTime.split(":");
    int dropHour = Integer.parseInt(drop[0]);
    int dropMinute = Integer.parseInt(drop[1]);
    int dropSecond = Integer.parseInt(drop[2]);
    int dropSecondAmount = dropHour * 3600 + dropMinute * 60 + dropSecond;

    int needSecondAmount = dropSecondAmount - currentSecondAmount;
    // 1초보다 크거나 같고, 24시간보다 작거나 같으므로 0보다 작거나 같아야함
    // 0보다 작은 값으로 한다면, 00:00:00 이 나올 수 있음
    if (needSecondAmount <= 0) {
      needSecondAmount += 24 * 3600;
    }

    int answerHour = needSecondAmount / 3600;
    int answerMinute = (needSecondAmount % 3600) / 60;
    int answerSecond = needSecondAmount % 60;

    System.out.printf("%02d:%02d:%02d%n", answerHour, answerMinute, answerSecond);
  }
}
