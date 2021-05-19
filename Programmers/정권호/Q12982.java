package programers.lv1._0512;

import java.util.Arrays;

public class Q12982 {
    class Solution {
        public int solution(int[] d, int budget) {
            int answer = 0;
            Arrays.sort(d);
            for (int i = 0; i < d.length; i++) {
                budget -= d[i];
                if (budget <= 0) {
                    if (budget == 0) {
                        i++;
                    }
                    answer = i;
                    break;
                }
            }

            if(budget > 0) {
                answer = d.length;
            }
            return answer;
        }
    }
}