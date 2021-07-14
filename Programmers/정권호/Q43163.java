package programers.lv3._0707;

public class Q43163 {


    class Solution {
        int min = 987654321;
        public int solution(String begin, String target, String[] words) {
            int answer = 0;
            boolean[] visited = new boolean[words.length];
            dfs(visited, words, begin, target, answer);
            if (min == 987654321) {
                min = 0;
            }
            return min;
        }

        void dfs(boolean[] visited, String[] words, String now, String target, int answer) {
            if (now.equals(target)) {
                min = Math.min(min, answer);
                return;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i]) {
                    char[] nowChar = now.toCharArray();
                    char[] wordChar = words[i].toCharArray();
                    int cnt = nowChar.length;
                    for (int i1 = 0; i1 < nowChar.length; i1++) {
                        if (wordChar[i1] == nowChar[i1]) {
                            cnt--;
                        }
                    }

                    if (cnt == 1) {
                        visited[i] = true;
                        dfs(visited, words, words[i], target, answer + 1);
                        visited[i] = false;
                    }
                }
            }
        }
    }

}


