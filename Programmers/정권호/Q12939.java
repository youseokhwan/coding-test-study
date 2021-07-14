package programers.lv2._0613;

import java.util.StringTokenizer;

public class Q12939 {
    class Solution {
        public String solution(String s) {
            String answer = "";
            StringTokenizer tokenizer = new StringTokenizer(s, " ");
            int min = 987654321;
            int max = -987654321;
            int countTokens = tokenizer.countTokens();

            for (int i = 0; i < countTokens; i++) {
                int now = Integer.parseInt(tokenizer.nextToken());
                min = Math.min(min, now);
                max = Math.max(max, now);
            }

            answer = min + " " + max;
            return answer;
        }
    }
}
