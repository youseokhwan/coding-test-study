package programers.lv2._0526;

import java.util.ArrayList;
import java.util.List;

public class Q42586 {
    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer = {};
            int[] days = new int[progresses.length];

            for (int i = 0; i < progresses.length; i++) {
                int day = (100 - progresses[i]) / speeds[i];
                if ((100 - progresses[i]) % speeds[i] != 0) {
                    day++;
                }
                days[i] = day;
            }

            List<Integer> answers = new ArrayList<>();
            int distribution = days[0];
            int cnt = 1;

            for (int i = 1; i < days.length; i++) {
                if (distribution < days[i]) {
                    answers.add(cnt);
                    cnt = 1;
                    distribution = days[i];
                    continue;
                }
                if (i == days.length - 1) {
                    answers.add(cnt);
                }
                cnt++;
            }

            answer = new int[answers.size()];

            for (int i = 0; i < answers.size(); i++) {
                answer[i] = answers.get(i);
            }

            return answer;
        }
    }
}
