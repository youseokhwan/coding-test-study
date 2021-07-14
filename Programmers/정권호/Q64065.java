package programers.lv2._0623;

import java.util.Arrays;
import java.util.Comparator;

public class Q64065 {
    class Solution {
        public int[] solution(String s) {
            int[] answer = {};
            int[] counting = new int[100001];

            s = s.substring(1, s.length() - 1); // 처음과 끝 괄호 제거
            String[] split = s.split("\\}"); // 원소 쪼개기

            for (int i = 0; i < split.length; i++) {
                if (i == 0) {
                    split[i] = split[i].substring(1); // 첫번째 원소만 1개
                    continue;
                }
                split[i] = split[i].substring(2); // 나머진 2개씩

            }

            Arrays.sort(split, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() - o2.length();
                }
            });

            answer = new int[split.length];

            for (int i = 0; i < split.length; i++) {
                String[] now = split[i].split(",");
                for (int j = 0; j < now.length; j++) {
                    int num = Integer.parseInt(now[j]);
                    if (counting[num] == 0) {
                        counting[num]++;
                        answer[i] = num;
                        break;
                    }
                }
            }
            return answer;
        }
    }
}

