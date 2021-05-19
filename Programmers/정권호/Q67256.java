package programers.lv1._0512;

import java.util.LinkedList;
import java.util.Queue;

public class Q67256 {

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        int[][] map = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -2}};
        boolean[][] visited = new boolean[4][3];
        int nowL = -1;
        int nowR = -2;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                nowL = numbers[i];
                continue;
            }
            if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                nowR = numbers[i];
                continue;
            }

            int[] now = new int[2];
            for (int y = 0; y < 4; y++) {
                for (int x = 0; x < 3; x++) {
                    if (map[y][x] == numbers[i]) {
                        now = new int[]{y, x, 0};
                        break;
                    }
                }
            }

            int cntL = -1;
            int cntR = -1;

            Queue<int[]> queue = new LinkedList<>();
            visited = new boolean[4][3];
            queue.add(now);

            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int ny = poll[0];
                int nx = poll[1];
                visited[ny][nx] = true;
                if (map[ny][nx] == nowL) {
                    cntL = poll[2] + 1;
                }
                if (map[ny][nx] == nowR) {
                    cntR = poll[2] + 1;
                }
                if (cntL != -1 && cntR != -1) {
                    break;
                }

                for (int j = 0; j < 4; j++) {
                    int y = ny + dy[j];
                    int x = nx + dx[j];
                    if (y >= 0 && y < 4 && x >= 0 && x < 3 && !visited[y][x]) {
                        queue.add(new int[]{y, x, poll[2] + 1});
                    }

                }
            }
            if (cntL == cntR) {
                if (hand.equals("left")) {
                    answer += "L";
                    nowL = numbers[i];
                    continue;
                }
                answer += "R";
                nowR = numbers[i];
                continue;
            }

            if (cntL > cntR) {
                answer += "R";
                nowR = numbers[i];
                continue;
            }

            answer += "L";
            nowL = numbers[i];
        }
        return answer;

    }

    public static void main(String[] args) {
        solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
    }

}
