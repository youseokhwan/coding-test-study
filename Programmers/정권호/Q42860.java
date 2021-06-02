package programers.lv2._0519;

import java.util.List;

public class Q42860 {
    public static int min;
    public static int total;

    public static void dfs(int idx, boolean[] visited, String name, int answer, int now) {
        if (total == now) {
            min = Math.min(min, answer);
            return;
        }

        for (int i = idx; i < name.length(); i++) {
            if (!visited[i] && name.charAt(i) != 'A') {
                visited[i] = true;
                dfs(i, visited, name, answer + i - idx, now + 1);
                visited[i] = false;
                break;
            }
        }

        for (int i = idx; i >= 0; i--) {
            if (!visited[i] && name.charAt(i) != 'A') {
                visited[i] = true;
                dfs(i, visited, name, answer + idx - i,now + 1);
                visited[i] = false;
                break;
            }
            if (i == 0) {
                for (int j = name.length() - 1; j >= 0; j--) {
                    if (!visited[j] && name.charAt(j) != 'A') {
                        visited[j] = true;
                        dfs(j, visited, name, answer + name.length() - j + idx, now + 1);
                        visited[j] = false;
                        break;
                    }
                }
            }
        }

    }

    public static int solution(String name) {
        int answer = 0;

        char[] buf = "A".repeat(name.length()).toCharArray();
        int cnt = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) != 'A') {
                answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
                cnt++;
            }
        }
        boolean[] visited = new boolean[name.length()];
        total = cnt;
        min = 987654321;
        dfs(0, visited, name, answer, 0);


//
//        int idx = 0;
//        while (!name.equals(String.valueOf(buf))) {
//            int right = 0;
//            int left = 0;
//            int lidx = 0;
//            int ridx = 0;
//
//            for (int i = idx; i < buf.length; i++) {
//                if (buf[i] != name.charAt(i)) {
//                    ridx = i;
//                    break;
//                }
//                right++;
//            }
//
//            for (int i = idx; i >= 0; i--) {
//                if (buf[i] != name.charAt(i)) {
//                    lidx = i;
//                    break;
//                }
//                if (i == 0) {
//                    for (int j = buf.length - 1; j >= 0; j--) {
//                        left++;
//                        if (buf[j] != name.charAt(j)) {
//                            lidx = j;
//                            break;
//                        }
//                    }
//                }
//            }
//
//            if (right > left + idx) {
//                answer += left + idx;
//                idx = lidx;
//                System.out.println("왼쪽으로 이동");
//            } else {
//                answer += right;
//                idx = ridx;
//                System.out.println("오쪽으로 이동");
//            }
//
//            int min = Math.min(name.charAt(idx) - 'A', 'Z' - name.charAt(idx) + 1);
//            System.out.println(min);
//            System.out.println(
//
//            );
//            answer += min;
//            buf[idx] = name.charAt(idx);
//
//        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(solution("JEROEN"));
    }
}
