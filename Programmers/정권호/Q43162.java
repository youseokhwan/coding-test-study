package programers.lv3._0630;

import java.util.Stack;

public class Q43162 {
    class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] visited = new boolean[n];

            for (int i = 0; i < computers.length; i++) {
                if (visited[i]) {
                    continue;
                }
                answer++;
                visited[i] = true;
                for (int j = 0; j < computers[i].length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (computers[i][j] == 1 && !visited[j]) {
                        Stack<Integer> stack = new Stack<>();
                        stack.add(j);
                        visited[j] = true;
                        while (!stack.isEmpty()) {
                            Integer pop = stack.pop();
                            for (int k = 0; k < computers[pop].length; k++) {
                                if (!visited[k] || k == pop) {
                                    continue;
                                }
                                if (computers[pop][k] == 1) {
                                    visited[k] = true;
                                    stack.add(k);

                                }
                            }
                        }
                    }
                }
            }
            return answer;
        }
    }

}
