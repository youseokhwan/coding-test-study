package programers.lv3._0711;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q42627 {
    class Solution {
        public int solution(int[][] jobs) {
            int answer = 0;
            Arrays.sort(jobs, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0])
                        return o1[1] - o2[1];
                    return o1[0] - o2[0];
                }
            });

            PriorityQueue<Integer[]> queue = new PriorityQueue<>(new Comparator<Integer[]>() {
                @Override
                public int compare(Integer[] o1, Integer[] o2) {
                    return o1[1] - o2[1];
                }
            });

            int now = 0;
            for (int i = 0; i < jobs.length; i++) {
                if (now >= jobs[i][0]) {
                    queue.add(new Integer[]{jobs[i][0], jobs[i][1]});
                    continue;
                }
                while (now < jobs[i][0] && !queue.isEmpty()) {
                    Integer[] poll = queue.poll();
                    now += poll[1];
                    answer += now - poll[0];
                }
                if (now < jobs[i][0]) {
                    now = jobs[i][0] + jobs[i][1];
                    answer += jobs[i][1];
                    continue;
                }
                queue.add(new Integer[]{jobs[i][0], jobs[i][1]});
            }

            while (!queue.isEmpty()) {
                Integer[] poll = queue.poll();
                now += poll[1];
                if (now < poll[0] + poll[1]) {
                    now = poll[0] + poll[1];
                }
                answer += now - poll[0];
            }

            answer /= jobs.length;
            return answer;
        }
    }
}

