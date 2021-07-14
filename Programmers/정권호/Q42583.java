package programers.lv2._0613;

import java.util.LinkedList;
import java.util.Queue;

public class Q42583 {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 1;
            int now = 0;
            int idx = 0;
            Queue<Integer[]> queue = new LinkedList<>();
            queue.add(new Integer[]{truck_weights[idx++], answer + bridge_length});
            now = truck_weights[0];

            while (!queue.isEmpty()) {
                answer++;
                Integer[] peek = queue.peek();
                if (answer == peek[1]) {
                    queue.poll();
                    now -= peek[0];
                }

                if (idx < truck_weights.length && weight >= now + truck_weights[idx]) {
                    if(idx == truck_weights.length - 1) {
                        answer += bridge_length;
                        break;
                    }
                    queue.add(new Integer[]{truck_weights[idx], answer + bridge_length});
                    now += truck_weights[idx];
                    idx++;

                }
            }
            return answer;
        }
    }
}
