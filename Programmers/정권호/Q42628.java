package programers.lv3._0714;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q42628 {
    class Solution {
        public int[] solution(String[] operations) {
            int[] answer = {};
            PriorityQueue<Integer> minQueue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });

            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

            int cnt = 0;

            for (int i = 0; i < operations.length; i++) {
                StringTokenizer tokenizer = new StringTokenizer(operations[i]);
                String s = tokenizer.nextToken();
                switch (s) {
                case "I":
                    String value = tokenizer.nextToken();
                    maxQueue.add(Integer.valueOf(value));
                    minQueue.add(Integer.valueOf(value));
                    break;
                case "D":
                    if (maxQueue.isEmpty()) {
                        break;
                    }
                    String c = tokenizer.nextToken();
                    if (c.equals("1")) {
                        Integer poll = maxQueue.poll();
                        minQueue.remove(poll);
                    } else {
                        Integer poll = minQueue.poll();
                        maxQueue.remove(poll);
                    }
                    break;
                }
            }

            if (maxQueue.isEmpty()) {
                return new int[]{0, 0};
            }
            answer = new int[]{maxQueue.poll(), minQueue.poll()};

            return answer;
        }
    }
}
