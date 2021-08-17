package baekjoon.next.SilverGold._0725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q7490 {
    public static List<String> answers = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int N = Integer.parseInt(reader.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(reader.readLine());
            bfs("1", 2, num, 1, 1);
            Collections.sort(answers);
            for (String answer : answers) {
                builder.append(answer).append("\n");
            }
            answers.clear();
            builder.append("\n");
        }
        System.out.println(builder);
    }

    // answer: 여태까지 입력, idx: 현재 위치, end: 목적지, value: 현재 값, before: 이전의 값
   public static void bfs(String answer, int idx, int end, int value, int before) {
        if (idx == end + 1) {
            if (value == 0) {
                answers.add(answer);
            }
            return;
        }

        // 더하는 경우
        bfs(answer + "+" + idx, idx + 1, end, value + idx, idx);
        // 빼는 경우
        bfs(answer + "-" + idx, idx + 1, end, value - idx, idx);

        // 이전 수식에 수를 더하는 경우
        char buf = ' ';
        String valueString = "";
        for (int i = answer.toCharArray().length - 1; i >= 0; i--) { // 수식이 있는 위치까지
            if (answer.charAt(i) == '+' || answer.charAt(i) == '-') {
                buf = answer.charAt(i);
                break;
            }
        }

        valueString += before; // 이전의 값
        valueString += idx; // 현재 값
        int valueInt = Integer.parseInt(valueString);

       if (buf == '-') {
           // 새로운 값에서 이전의 값의 차이만큼 반영 before : 4, new : 42 면 실질적으로 42 - 4 만큼 변화
           value -= valueInt - before;
       } else {
            value += valueInt - before;
        }

        bfs(answer + " " + idx, idx + 1, end, value, valueInt);
    }
}
