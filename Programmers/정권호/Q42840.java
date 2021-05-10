package programers.lv1._0502;

import java.util.ArrayList;
import java.util.List;

public class Q42840 {
    public int[] solution(int[] answers) {
        int[] answer = {0,0,0};

        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5,};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % one.length]) {
                answer[0]++;
            }

            if (answers[i] == two[i % two.length]) {
                answer[1]++;
            }

            if (answers[i] == three[i % three.length]) {
                answer[2]++;
            }
        }

        int max = Math.max(answer[0], answer[1]);
        max = Math.max(max, answer[2]);

        int cnt = 0;
        List<Integer> lists = new ArrayList<>();

        for (int i = 0 ; i < 3; i++) {
            if (max == answer[i]) {
                lists.add(i + 1);
            }
        }
        answer = lists.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}
