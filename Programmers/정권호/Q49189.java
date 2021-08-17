package programers.lv3._0725;


import java.util.ArrayList;
import java.util.HashMap;

public class Q49189 {
    public class Solution {
        int[] lengths = new int[20001];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        public void dfs(boolean[] visited, int now, int length) {
            ArrayList<Integer> list = map.get(now);
            for (Integer node : list) {
                if (!visited[node]) {
                    visited[node] = true;
                    if (lengths[node] == 0) { // 경로에 도달한 적 없는 경우
                        lengths[node] = length + 1;
                        dfs(visited, node, lengths[node]);
                    } else {
                        if (lengths[node] > length + 1) { // 경로에 도달한적이 있으나 현재 경로가 더 가까운 경우
                            lengths[node] = length + 1;
                            dfs(visited, node, lengths[node]);
                        }
                    }
                    visited[node] = false;
                }
            }
        }

        public int solution(int n, int[][] edge) {
            int answer = 0;
            boolean[] visited = new boolean[200001];
            for (int i = 0; i < edge.length; i++) {
                ArrayList<Integer> nodes = map.getOrDefault(edge[i][0], new ArrayList<Integer>());
                nodes.add(edge[i][1]);
                map.put(edge[i][0], nodes);

                ArrayList<Integer> nodes2 = map.getOrDefault(edge[i][1], new ArrayList<Integer>());
                nodes2.add(edge[i][0]);
                map.put(edge[i][1], nodes2);
            }
            visited[1] = true;
            dfs(visited, 1, 0);

            int max = -1;
            for (int i = 1; i < lengths.length; i++) {
                if (lengths[i] == 0) {
                    continue;
                }
                max = Math.max(max, lengths[i]);
            }

            for (int i = 1; i < lengths.length; i++) {
                if (lengths[i] == 0) {
                    continue;
                }
                if (lengths[i] == max) {
                    answer++;
                }
            }
            return answer;
        }
    }

}
