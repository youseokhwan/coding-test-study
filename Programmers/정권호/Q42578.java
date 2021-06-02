package programers.lv2._0526;

import java.util.HashMap;

public class Q42578 {
    class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            HashMap<String, Integer> bag = new HashMap<>();
            for (int i = 0; i < clothes.length; i++) {
                bag.put(clothes[i][1], bag.getOrDefault(clothes[i][1], 0) + 1);
            }

            for (Integer value : bag.values()) {
                answer *= value + 1;
            }
            answer--;
            return answer;
        }
    }
}
